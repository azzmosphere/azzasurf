package org.azzasurf.model;

import org.azzasurf.model.surforecast.Charts;
import org.azzasurf.model.surforecast.Conditions;
import org.azzasurf.model.surforecast.Swell;
import org.azzasurf.model.surforecast.Wind;


/**
 *
 * reference: http://magicseaweed.com/developer/forecast-api
 *
 * Created by aaron.spiteri on 14/08/2016.
 *
 */
public class SurfForecast {
    private long timestamp;       /* Time stamp */
    private long localTimestamp;  /* Local date time */
    private long issueTimestamp;  /* date request was made to MSW */

    /*
     * The two components together make up the overall rating. A solid 5 star rating (with zero faded dtars) is the
     * best possible. A rating of 2 solid stars and 2 faded stars means the there is significant swell (4 stars worth)
     * but a medium onshore wind reducing the wave quality. The solid stars must always be rendered first followed by
     * the faded stars.
     */
    private int fadedRating;      /* This signifies the number of stars you should show for the portion of the overall
                                     rating that has been effected by the wind. */
    private int solidRating;      /* This is the solid stars for the rating, which signifies swell quality/power. */
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
