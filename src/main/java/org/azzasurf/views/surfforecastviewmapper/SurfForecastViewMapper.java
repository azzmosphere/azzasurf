package org.azzasurf.views.surfforecastviewmapper;

import org.azzasurf.model.SurfForecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by aaron.spiteri on 20/08/2016.
 */
public class SurfForecastViewMapper extends SurfForecastViewAbstractBase  {
    private static final Logger logger = LoggerFactory.getLogger(SurfForecastViewMapper.class);

    private SurfForecast forecast;

    @Value("${view.filled_star}")
    private String filledStar;

    @Value("${view.faded_star}")
    private String fadedStar;

    private LocalDateTime epoch2Date(long epoch) {
        return Instant.ofEpochSecond (epoch).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public void setForecast(SurfForecast forecast) {
        this.forecast = forecast;
    }

    public SurfForecast getForecast() {
        return forecast;
    }

    public LocalDateTime getLocalTimestampTS() {
        return epoch2Date(forecast.getLocalTimestamp());
    }

    public LocalDateTime getIssueTimestampTS() {
        return epoch2Date(forecast.getIssueTimestamp());
    }

    public LocalDateTime getTimestampTS() {
        return epoch2Date(forecast.getIssueTimestamp());
    }

    public String getLocalTimeString() {
        return getLocalTimestampTS().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    public ArrayList<String> getSolidRating() {
        logger.debug("Solid star rating is " + getForecast().getSolidRating());
        return getStars(filledStar, getForecast().getSolidRating());
    }

    public ArrayList<String> getFadedRating() {
        logger.debug("Faded star rating is " + getForecast().getFadedRating());
        return getStars(fadedStar, getForecast().getFadedRating());
    }


    public int getSolidRatingAsInt() {
        return getForecast().getSolidRating();
    }

    public int getFadedRatingAsInt() {
        return getForecast().getFadedRating();
    }

    public String getWaveRange() {
        return getForecast().getSwell().getMinBreakingHeight() + getForecast().getSwell().getUnit() +
                " to " + getForecast().getSwell().getMaxBreakingHeight() + getForecast().getSwell().getUnit();
    }

    public String getCompass() {
        return getForecast().getWind().getCompassDirection();
    }

    public double getMinWaveHeight() {
        return getForecast().getSwell().getMinBreakingHeight();
    }

    public double getMaxWaveHeight() {
        return getForecast().getSwell().getMaxBreakingHeight();
    }


    public String getWaveHeightUnit() {
        return getForecast().getSwell().getUnit();
    }
}
