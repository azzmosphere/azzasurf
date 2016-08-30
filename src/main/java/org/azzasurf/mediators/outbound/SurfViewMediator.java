package org.azzasurf.mediators.outbound;

import org.azzasurf.model.SurfForecast;
import org.azzasurf.views.SurfForecastViewMapperCollection;
import org.azzasurf.views.surfforecastviewmapper.SurfForecastViewMapper;
import org.azzasurf.views.surfforecastviewmapper.SurfforecastGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron.spiteri on 20/08/2016.
 */
public class SurfViewMediator {

    private static final Logger logger = LoggerFactory.getLogger(SurfViewMediator.class);

    public static SurfForecastViewMapperCollection create(List<SurfForecast> list) {
        SurfForecastViewMapperCollection collection = new SurfForecastViewMapperCollection();

        try {

            SurfforecastGroup surfforecastGroup = null;
            List<SurfForecastViewMapper> subList = null;

            String cdate = null;
            for (SurfForecast attribute : list) {
                SurfForecastViewMapper forecast = new SurfForecastViewMapper();
                forecast.setForecast(attribute);

                if (cdate == null || !cdate.equals(forecast.getLocalTimestampTS().format(DateTimeFormatter.ISO_DATE))) {

                    if (surfforecastGroup != null) {
                        surfforecastGroup.setAttributes(subList);
                        collection.getCollection().add(surfforecastGroup);
                    }

                    cdate = forecast.getLocalTimestampTS().format(DateTimeFormatter.ISO_DATE);
                    surfforecastGroup = new SurfforecastGroup();
                    surfforecastGroup.setDisplayDate(forecast.getLocalTimestampTS().getDayOfMonth() + " " + forecast.getLocalTimestampTS().getMonth().name().substring(0,3));
                    surfforecastGroup.setDisplayDay(forecast.getLocalTimestampTS().getDayOfWeek().name());
                    subList = new ArrayList<>();
                    subList.add(forecast);
                }
                else if (subList != null) {
                    subList.add(forecast);
                }
            }
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            logger.error(e.getCause().toString());
            logger.error(e.getStackTrace().toString());
        }

        return collection;
    }

}
