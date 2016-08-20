package org.azzasurf.views;

import org.azzasurf.model.SurfForecast;
import org.azzasurf.views.surfforecastviewmapper.SurfforecastGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron.spiteri on 19/08/2016.
 */
public class SurfForecastViewMapperCollection extends SurfForecast {
    private List<SurfforecastGroup> collection = new ArrayList<>();

    public List<SurfforecastGroup> getCollection() {
        return collection;
    }
}
