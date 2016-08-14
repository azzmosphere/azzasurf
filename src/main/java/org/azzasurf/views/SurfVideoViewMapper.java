package org.azzasurf.views;

import org.springframework.web.servlet.ModelAndView;
import org.azzasurf.model.Video;

/**
 * Created by aaron.spiteri on 14/08/2016.
 */
public class SurfVideoViewMapper {

    public void mapView(ModelAndView model, Video[] videos) {
        model.addObject("videos", videos);
    }

}
