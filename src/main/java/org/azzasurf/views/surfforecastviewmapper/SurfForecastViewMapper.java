package org.azzasurf.views.surfforecastviewmapper;

import org.azzasurf.model.SurfForecast;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by aaron.spiteri on 20/08/2016.
 */
public class SurfForecastViewMapper  {

    private SurfForecast forecast;

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
}
