package org.azzasurf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.azzasurf.model.Video;
import org.azzasurf.model.actions.GenerateSurfVideoCollection;
import java.util.List;

/**
 *
 * Controller for surf video's
 *
 * Created by aaron.spiteri on 5/08/2016.
 */

@Controller
public class AzzaSurfVids {
    private static final Logger logger = LoggerFactory.getLogger(AzzaSurfVids.class);
    //private SurfVideoViewMapper viewMapper = new SurfVideoViewMapper();

    @Autowired
    private GenerateSurfVideoCollection videoCollection;

    @ModelAttribute(value="videos")
    private Video[] prepareData() {
        List<Video> videos = videoCollection.retrieveAll();
        return videos.toArray(new Video[videos.size()]);
    }

    @RequestMapping(value="/videos",method= RequestMethod.GET)
    public String view(ModelAndView model) {

        logger.debug("displaying surf video's");

        return "surfvids";
    }
}
