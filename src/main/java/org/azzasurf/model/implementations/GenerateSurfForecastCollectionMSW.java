package org.azzasurf.model.implementations;

import org.azzasurf.model.SurfForecast;
import org.azzasurf.model.actions.GenerateSurfForecastCollection;

import java.util.HashMap;

/**
 * Created by aaron.spiteri on 14/08/2016.
 */
public class GenerateSurfForecastCollectionMSW implements GenerateSurfForecastCollection {
    @Override
    public SurfForecast create(SurfForecast element) {
        return null;
    }

    @Override
    public SurfForecast[] retrieve(HashMap<String, Object> params) {
        return new SurfForecast[0];
    }

    @Override
    public SurfForecast[] retrieve_all() {
        return new SurfForecast[0];
    }

    @Override
    public SurfForecast update(SurfForecast element) {
        return null;
    }

    @Override
    public boolean delete(SurfForecast element) {
        return false;
    }
}
