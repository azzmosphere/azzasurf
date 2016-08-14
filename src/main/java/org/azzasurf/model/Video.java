package org.azzasurf.model;

import java.net.URI;

/**
 * Elements needed to display a video.
 *
 * Created by aaron.spiteri on 13/08/2016.
 */

public class Video {
    private String vidname;
    private URI srcLocation;

    public String getVidname() {
        return vidname;
    }

    public void setVidname(String vidname) {
        this.vidname = vidname;
    }

    public URI getSrcLocation() {
        return srcLocation;
    }

    public void setSrcLocation(URI srcLocation) {
        this.srcLocation = srcLocation;
    }
}
