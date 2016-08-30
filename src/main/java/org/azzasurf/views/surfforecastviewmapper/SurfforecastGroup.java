package org.azzasurf.views.surfforecastviewmapper;

import org.azzasurf.model.SurfForecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;

/**
 * Logical grouping of surf forecasts that have a specific related grouping such as the same day.
 *
 * Created by aaron.spiteri on 20/08/2016.
 */
public class SurfforecastGroup extends SurfForecastViewAbstractBase {
    private String displayDate;
    private String displayDay;
    private List<SurfForecastViewMapper> attributes;
    private int maxRatingIdx = -1;

    @Value("${view.filled_star}")
    private String filledStar;

    @Value("${view.faded_star}")
    private String fadedStar;

    private static final Logger logger = LoggerFactory.getLogger(SurfforecastGroup.class);

    public String getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(String displayDate) {
        this.displayDate = displayDate;
    }

    public List<SurfForecastViewMapper> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<SurfForecastViewMapper> attributes) {
        this.attributes = attributes;
    }

    public String getDisplayDay() {
        return displayDay;
    }

    public void setDisplayDay(String displayDay) {
        this.displayDay = displayDay;
    }


    public String getDisplayDayFormatted() {
        return getDisplayDay().substring(0,3);
    }

    public SurfForecastViewMapper getMorning() {
        logger.debug("get morning attributes");
        return attributes.get(0);
    }


    private int getAvg(String method) {
        int total = 0, count = 0;
        for (SurfForecastViewMapper sf : attributes) {

            try {
                Method m = sf.getClass().getMethod(method, null);
                total += (int) m.invoke(sf);
                count++;
            }
            catch (Exception e ) {
                logger.error("Could not process rating for " + method + ":" + e.getMessage());

                logger.debug(e.getCause().toString());
                for (StackTraceElement el : e.getStackTrace()) {
                    logger.debug(el.toString());
                }
            }
        }

        if (total == 0 || count == 0) {
            return 0;
        }

        return total / count;
    }

    /**
     * Generate a list of stars for the average solid rating for the group.
     *
     * @return list of star url
     */
    public ArrayList<String> getAvgSolidRating() {
        return getStars(filledStar, getAvg("getSolidRatingAsInt"));
    }

    /**
     * Generate a list of stars for the average faded rating for the group.
     *
     * @return list of star url
     */
    public ArrayList<String> getAvgFadedRating() {
        return getStars(filledStar, getAvg("getFadedRatingAsInt"));
    }


    private double getMinWaveHeight() {
        double minWaveHeight = 0;
        for (SurfForecastViewMapper sf : attributes) {
            if (minWaveHeight == 0 || minWaveHeight > sf.getMinWaveHeight()) {
                minWaveHeight = sf.getMinWaveHeight();
            }
        }

        return minWaveHeight;
    }

    private double getMaxWaveHeight() {
        double maxWaveHeight = 0;
        for (SurfForecastViewMapper sf : attributes) {
            if (maxWaveHeight < sf.getMaxWaveHeight()) {
                maxWaveHeight = sf.getMaxWaveHeight();
            }
        }

        return maxWaveHeight;
    }

    public String getWaveRange() {
        SurfForecastViewMapper sf = attributes.get(0);
        return getMinWaveHeight() + sf.getForecast().getSwell().getUnit() +
                " to " + getMaxWaveHeight() + sf.getForecast().getSwell().getUnit();
    }

    private int computeBestRating() {
        int index = 0, maxRating = 0;

        for (int i = 0; i < attributes.size(); i ++) {
            SurfForecastViewMapper sf = attributes.get(i);

            if ((sf.getFadedRatingAsInt() + sf.getSolidRatingAsInt()) > maxRating) {
                maxRating = sf.getFadedRatingAsInt() + sf.getSolidRatingAsInt();
                index = i;
            }
        }
        return index;
    }

    public  ArrayList<String>  getMaxSolidStarRating() {
        if (maxRatingIdx == -1) {
            maxRatingIdx = computeBestRating();
        }

        return getStars(filledStar, attributes.get(maxRatingIdx).getSolidRatingAsInt());
    }

    public  ArrayList<String>  getMaxFadedStarRating() {
        if (maxRatingIdx == -1) {
            maxRatingIdx = computeBestRating();
        }

        return getStars(filledStar, attributes.get(maxRatingIdx).getFadedRatingAsInt());
    }
}
