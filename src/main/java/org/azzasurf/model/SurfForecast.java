package org.azzasurf.model;

import org.azzasurf.model.surforecast.Charts;
import org.azzasurf.model.surforecast.Conditions;
import org.azzasurf.model.surforecast.Swell;
import org.azzasurf.model.surforecast.Wind;

import java.util.Date;

/**
 * Created by aaron.spiteri on 14/08/2016.
 *
 */
public class SurfForecast {
    private Date timestamp;       /* Time stamp */
    private Date localTimestamp;  /* Local date time */
    private Date issueTimestamp;  /* date request was made to MSW */
    private int fadedRating;      /* Some sort of number */
    private int solidRating;      /* Some sort of number */
    private Swell swell;
    private Wind wind;
    private Conditions conditions;
    private Charts charts;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getLocalTimestamp() {
        return localTimestamp;
    }

    public void setLocalTimestamp(Date localTimestamp) {
        this.localTimestamp = localTimestamp;
    }

    public Date getIssueTimestamp() {
        return issueTimestamp;
    }

    public void setIssueTimestamp(Date issueTimestamp) {
        this.issueTimestamp = issueTimestamp;
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

    public Conditions getConditions() {
        return conditions;
    }

    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    public Charts getCharts() {
        return charts;
    }

    public void setCharts(Charts charts) {
        this.charts = charts;
    }
}
