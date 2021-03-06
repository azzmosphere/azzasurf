package org.azzasurf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * This is the main controller, it can be coded for now, but might be a good idea to move it to SWF
 *
 * Created by aaron.spiteri on 27/07/2016.
 */
@Controller
public class AzzaSurf {

    private static final Logger logger = LoggerFactory.getLogger(AzzaSurf.class);


    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }



    @RequestMapping(value="/hello/{name}",method=RequestMethod.GET)
    public String view(@PathVariable("name") String name, ModelAndView model) {

        logger.info("name = " + name);

        return "HelloWorldPage";
    }
}
