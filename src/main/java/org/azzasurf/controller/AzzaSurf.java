package org.azzasurf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * This is the main controller, it can be coded for now, but might be a good idea to move it to SWF
 *
 * Created by aaron.spiteri on 27/07/2016.
 */
@Controller
public class AzzaSurf {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {

        ModelAndView model = new ModelAndView();
        model.setViewName("HelloWorldPage");
        model.addObject("msg", name);

        return model;
    }

    @RequestMapping(value = "/vids/", method = RequestMethod.GET)
    public ModelAndView getVids() {
        ModelAndView model = new ModelAndView();
        model.setViewName("surfvids");
        return model;
    }
}
