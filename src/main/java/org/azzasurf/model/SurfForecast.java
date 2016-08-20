package org.azzasurf.model;

import org.azzasurf.model.surforecast.Charts;
import org.azzasurf.model.surforecast.Conditions;
import org.azzasurf.model.surforecast.Swell;
import org.azzasurf.model.surforecast.Wind;


/**
 * Created by aaron.spiteri on 14/08/2016.
 *
 */
public class SurfForecast {
    private long timestamp;       /* Time stamp */
    private long localTimestamp;  /* Local date time */
    private long issueTimestamp;  /* date request was made to MSW */
    private int fadedRating;      /* Some sort of number */
    private int solidRating;      /* Some sort of number */
    private Swell swell;
    private Wind wind;
    private Conditions condition;
    private Charts charts;


    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getLocalTimestamp() {
        return localTimestamp;
    }

    public void setLocalTimestamp(long localTimestamp) {
        this.localTimestamp = localTimestamp;
    }

    public long getIssueTimestamp() {
        return issueTimestamp;
    }

    public void setIssueTimestamp(long issueTimestamp) {
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
