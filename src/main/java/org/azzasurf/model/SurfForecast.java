package org.azzasurf.model;

import org.azzasurf.model.surforecast.Charts;
import org.azzasurf.model.surforecast.Conditions;
import org.azzasurf.model.surforecast.Swell;
import org.azzasurf.model.surforecast.Wind;

import java.time.LocalDate;
import java.time.Instant;
import java.time.ZoneId;

/**
 * Created by aaron.spiteri on 14/08/2016.
 *
 */
public class SurfForecast {
    private LocalDate timestamp;       /* Time stamp */
    private LocalDate localTimestamp;  /* Local date time */
    private LocalDate issueTimestamp;  /* date request was made to MSW */
    private int fadedRating;      /* Some sort of number */
    private int solidRating;      /* Some sort of number */
    private Swell swell;
    private Wind wind;
    private Conditions condition;
    private Charts charts;

    private LocalDate getLocalTime(long epoch) {
        return Instant.ofEpochSecond (epoch).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = getLocalTime(timestamp);
    }

    public LocalDate getLocalTimestamp() {
        return localTimestamp;
    }

    public void setLocalTimestamp(long localTimestamp) {
        this.localTimestamp = getLocalTime(localTimestamp);
    }

    public LocalDate getIssueTimestamp() {
        return issueTimestamp;
    }

    public void setIssueTimestamp(long issueTimestamp) {
        this.issueTimestamp = getLocalTime(issueTimestamp);
    }

    public int getFadedRating() {
        return fadedRating;
    }

    public void setFadedRating(int fadedRating) {
        this.fadedRating = fadedRating;
    }

    public int getSolidRating() {
        return solidRating;
    }

    public void setSolidRating(int solidRating) {
        this.solidRating = solidRating;
    }

    public Swell getSwell() {
        return swell;
    }

    public void setSwell(Swell swell) {
        this.swell = swell;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Conditions getCondition(){
        return condition;
    }

    public void setCondition(Conditions condition) {
        this.condition = condition;
    }

    public Charts getCharts() {
        return charts;
    }

    public void setCharts(Charts charts) {
        this.charts = charts;
    }
}
