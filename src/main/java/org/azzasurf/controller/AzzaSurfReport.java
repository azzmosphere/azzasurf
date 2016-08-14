package org.azzasurf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Surf report predictions.
 *
 * Created by aaron.spiteri on 14/08/2016.
 */
@Controller
public class AzzaSurfReport {

    @RequestMapping(value="/forecast",method= RequestMethod.GET)
    public String getForecast() {
        return "surfreport";
    }
}
