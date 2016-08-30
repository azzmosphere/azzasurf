package org.azzasurf.model.implementations;

import org.azzasurf.model.SurfForecast;
import org.azzasurf.model.actions.GenerateSurfForecastCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaron.spiteri on 14/08/2016.
 */
public class GenerateSurfForecastCollectionMSW extends JSONAbstractBase<SurfForecast> implements GenerateSurfForecastCollection {

    private static final Logger logger = LoggerFactory.getLogger(GenerateSurfForecastCollectionMSW.class);

    @Value("${msw.url}")
    private String msw_url;

    @Value("${msw.key}")
    private String msw_key;

    @Value("${msw.secret}")
    private String msw_secret;

    @Value("${msw.spotrequest}")
    private String msw_spotrequest;

    private List<SurfForecast> attributes;

    private final String JAN_JUC = "1066";
    private final String POINT_ADDIS = "1067";

    private final String SPORT_ID = JAN_JUC;

    @Override
    public String getUrlRequest() {
        return msw_url + msw_key + msw_spotrequest + SPORT_ID;
    }

    @Override
    public SurfForecast create(SurfForecast element) {
        return null;
    }

    @Override
    public List<SurfForecast> retrieve(HashMap<String, Object> params) {
        return null;
    }

    @Override
    public SurfForecast update(SurfForecast element) {
        return null;
    }

    @Override
    public boolean delete(SurfForecast element) {
        return false;
    }

    @Override
    public Class getClassT() {
        return SurfForecast[].class;
    }

    @Override
    public void setDeserialisedList(List<SurfForecast> attributes) {
        this.attributes = attributes;
    }
}
