package org.azzasurf.controller.implementations;

import org.azzasurf.controller.actions.GenerateSurfVideoCollection;
import org.azzasurf.model.Video;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.boot.json.JsonParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.apache.commons.io.IOUtils;
import java.net.URL;
import java.net.URI;

/**
 * Retrieves videos from a JSON configfile.
 *
 * Created by aaron.spiteri on 13/08/2016.
 */
public class GenerateSurfVideoCollectionJSON implements GenerateSurfVideoCollection, ResourceLoaderAware {

    private static final Logger logger = LoggerFactory.getLogger(GenerateSurfVideoCollectionJSON.class);
    private JsonParser jsonParser =  JsonParserFactory.getJsonParser();
    private final String ROOT_NODE = "videos";
    private ResourceLoader resourceLoader;

    @Value("${json.videos}")
    private String SURF_VID_FILE;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public Video[] getVideos() {
        logger.debug("getting files from " + SURF_VID_FILE);
        Video[] videos;

        //TODO convert the exceptions into something meaningful
        try {
            URL url = new URL(SURF_VID_FILE);
            InputStream is = url.openStream();
            String content = new String(IOUtils.toByteArray(is), "US-ASCII");

            Map<String, Object> attributes = jsonParser.parseMap(content);

            if (attributes.containsKey(ROOT_NODE)) {
                videos = mapAttributes(attributes, ROOT_NODE);
            }
            else {
                throw new Exception("Unable to find root node :" + ROOT_NODE);
            }
        }
        catch(Exception  e) {
            videos = new Video[0];
            logger.error("Unable to parse JSON " + e.toString());
        }
        return videos;
    }

    private Video[]  mapAttributes(Map<String, Object> map, String rootNode) throws Exception {

        ArrayList<Map<String, Object>> attributes = (ArrayList<Map<String, Object>>) map.get(rootNode);
        Video[] videos = new Video[attributes.size()];
        int i = 0;
        for (Map<String, Object> attribute : attributes) {
            Video video = new Video();
            video.setSrcLocation(new URI((String)attribute.get("srcLocation")));
            video.setVidname((String) attribute.get("vidname"));
            videos[i++] = video;
        }

        return videos;
    }
}
