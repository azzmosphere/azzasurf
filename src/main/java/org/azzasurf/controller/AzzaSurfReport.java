package org.azzasurf.controller;

import org.azzasurf.model.SurfForecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.azzasurf.model.actions.GenerateSurfForecastCollection;
import java.util.List;

/**
 * Surf report predictions.
 *
 * Created by aaron.spiteri on 14/08/2016.
 */
@Controller
public class AzzaSurfReport {

    private static final Logger logger = LoggerFactory.getLogger(AzzaSurfReport.class);

    @Autowired
    private GenerateSurfForecastCollection generateSurfForecastCollection;

    @ModelAttribute
    private SurfForecast[] getSurfcast() {
        List<SurfForecast> surfForecasts = generateSurfForecastCollection.retrieve_all();
        return surfForecasts.toArray(new SurfForecast[surfForecasts.size()]);
    }

    @RequestMapping(value="/forecast",method= RequestMethod.GET)
    public String getForecast() {
        logger.debug("displaying surf report");
        return "surfreport";
    }
}
