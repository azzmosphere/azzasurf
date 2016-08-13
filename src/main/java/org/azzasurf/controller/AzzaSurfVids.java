package org.azzasurf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * Controller for surf video's
 *
 * Created by aaron.spiteri on 5/08/2016.
 */

@Controller
public class AzzaSurfVids {
    private static final Logger logger = LoggerFactory.getLogger(AzzaSurfVids.class);

    @RequestMapping(value="/videos",method= RequestMethod.GET)
    public String view() {

        logger.info("displaying surf video's");

        return "surfvids";
    }
}
