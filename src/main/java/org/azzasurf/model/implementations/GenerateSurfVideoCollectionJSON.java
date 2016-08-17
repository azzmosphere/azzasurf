package org.azzasurf.model.implementations;

import org.azzasurf.model.Video;
import org.azzasurf.model.actions.GenerateSurfVideoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.boot.json.JsonParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ResourceLoader;
import org.apache.commons.io.IOUtils;
import java.net.URL;
import java.net.URI;

/**
 * Retrieves videos from a JSON configfile.
 *
 * Created by aaron.spiteri on 13/08/2016.
 */
public class GenerateSurfVideoCollectionJSON extends JSONAbstractBase<Video> implements GenerateSurfVideoCollection {

    private static final Logger logger = LoggerFactory.getLogger(GenerateSurfVideoCollectionJSON.class);
    private JsonParser jsonParser =  JsonParserFactory.getJsonParser();
    private final String ROOT_NODE = "videos";
    private ResourceLoader resourceLoader;

    @Value("${json.videos}")
    private String SURF_VID_FILE;

    @Override
    public String getUrlRequest() {
        return SURF_VID_FILE;
    }

    @Override
    public Video  build(Map<String, Object> map) throws Exception {
        Video video = new Video();
        video.setSrcLocation(new URI((String)map.get("srcLocation")));
        video.setVidname((String) map.get("vidname"));

        return video;
    }

    @Override
    public Video create(Video element) {
        return null;
    }

    @Override
    public List<Video> retrieve(HashMap<String, Object> params) {
        return null;
    }

    @Override
    public Video update(Video element) {
        return null;
    }

    @Override
    public boolean delete(Video element) {
        return false;
    }
}
