package org.azzasurf.controller.actions;

import org.azzasurf.model.Video;

/**
 *
 * Retrieves a list of current video's from the data source.
 *
 * Created by aaron.spiteri on 13/08/2016.
 */
public interface GenerateSurfVideoCollection {
    /**
     * Get list of current viedeos
     * @return
     */
    Video[] getVideos();
}
