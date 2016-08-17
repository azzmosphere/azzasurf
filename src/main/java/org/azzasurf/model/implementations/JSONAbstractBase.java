package org.azzasurf.model.implementations;

import org.apache.commons.io.IOUtils;
import org.azzasurf.model.actions.JSONCrud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.lang.Object;

/**
 * Created by aaron.spiteri on 17/08/2016.
 */
public abstract class JSONAbstractBase<T> implements JSONCrud<T> {
    private static final Logger logger = LoggerFactory.getLogger(JSONAbstractBase.class);
    private JsonParser jsonParser =  JsonParserFactory.getJsonParser();

    @Override
    public List<T> retrieve_all() {
        //String url_req = ; //msw_url + msw_key + msw_spotrequest + JAN_JUC;
        String url_req = getUrlRequest();
        List<T> objList = new ArrayList<>();

        try {
            logger.debug("using URL " + url_req);
            URL url = new URL(url_req);

            InputStream is = url.openStream();
            String content = new String(IOUtils.toByteArray(is), "US-ASCII");

            List<Object> attributes =  jsonParser.parseList(content);

            for (Object attribute :  attributes) {
                Map<String, Object> map = (Map<String, Object>) attribute;
                objList.add(build(map));
            }
        }
        catch (Exception e) {
            if (logger.isDebugEnabled()) {
                logger.debug(e.getStackTrace().toString());
            }
            logger.error("error occurred while retrieving " + e.getMessage());
        }

        return objList;
    }

}
