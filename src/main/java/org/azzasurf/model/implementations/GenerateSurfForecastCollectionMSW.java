package org.azzasurf.model.implementations;

import org.azzasurf.model.SurfForecast;
import org.azzasurf.model.actions.GenerateSurfForecastCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaron.spiteri on 14/08/2016.
 */
public class GenerateSurfForecastCollectionMSW extends JSONAbstractBase<SurfForecast> implements GenerateSurfForecastCollection {

    private static final Logger logger = LoggerFactory.getLogger(GenerateSurfForecastCollectionMSW.class);

    private String msw_url;
    private String msw_key;
    private String msw_secret;
    private String msw_spotrequest;

    private final String JAN_JUC = "1066";

    public String getMsw_url() {
        return msw_url;
    }

    public void setMsw_url(String msw_url) {
        this.msw_url = msw_url;
    }

    public String getMsw_key() {
        return msw_key;
    }

    public void setMsw_key(String msw_key) {
        this.msw_key = msw_key;
    }

    public String getMsw_secret() {
        return msw_secret;
    }

    public void setMsw_secret(String msw_secret) {
        this.msw_secret = msw_secret;
    }

    public String getMsw_spotrequest() {
        return msw_spotrequest;
    }

    public void setMsw_spotrequest(String msw_spotrequest) {
        this.msw_spotrequest = msw_spotrequest;
    }

    @Override
    public String getUrlRequest() {
        return msw_url + msw_key + msw_spotrequest + JAN_JUC;
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
}
