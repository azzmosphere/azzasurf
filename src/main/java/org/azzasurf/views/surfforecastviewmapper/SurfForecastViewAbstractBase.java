package org.azzasurf.views.surfforecastviewmapper;

import java.util.ArrayList;

/**
 * Created by aaron.spiteri on 25/08/2016.
 */
public abstract class SurfForecastViewAbstractBase {
    protected ArrayList<String> getStars(String ref, int rating) {
        ArrayList<String> stars = new ArrayList<>();
        for (int i = 0;i < rating; i ++) {
            stars.add(ref);
        }
        return stars;
    }
}
