package org.azzasurf.views;

import org.azzasurf.model.SurfForecast;
import org.springframework.web.servlet.ModelAndView;
import org.azzasurf.model.Video;

import java.time.LocalDate;
import java.time.Instant;
import java.time.ZoneId;

/**
 * Created by aaron.spiteri on 14/08/2016.
 */
public class SurfVideoViewMapper {

    //TODO Remove this development code
    public void scratchPlate() {
        SurfForecast sf = new SurfForecast();

        sf.getTimestamp();
        sf.getSwell().getMinBreakingHeight();
        sf.getSwell().getMaxBreakingHeight();

        sf.getSwell().getUnit();

        LocalDate d = Instant.ofEpochMilli(1471564800).atZone(ZoneId.systemDefault()).toLocalDate();
    }


    public void mapView(ModelAndView model, Video[] videos) {
        model.addObject("videos", videos);
    }

}
