package org.azzasurf.controller;

import org.azzasurf.model.actions.GenerateSurfForecastCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by aaron.spiteri on 30/08/2016.
 */
@Controller
public class AzzaDetailedSurfReport {

    private static final Logger logger = LoggerFactory.getLogger(AzzaDetailedSurfReport.class);

    private static final String controllerKey = "/detailedrpt/";

    @Autowired
    private GenerateSurfForecastCollection generateSurfForecastCollection;

    @RequestMapping(value=controllerKey, method= RequestMethod.GET)
    public String getForecast() {

        logger.debug("displaying detailed surf report");
        return "surfreport";
    }
}
