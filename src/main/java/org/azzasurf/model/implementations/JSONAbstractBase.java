package org.azzasurf.model.implementations;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParser;

import org.apache.commons.io.IOUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.azzasurf.model.actions.JSONCrud;

/**
 * Created by aaron.spiteri on 17/08/2016.
 */
public abstract class JSONAbstractBase<T> implements JSONCrud<T> {
    private static final Logger logger = LoggerFactory.getLogger(JSONAbstractBase.class);
    private JsonFactory jsonFactory = new JsonFactory();
    private ObjectMapper objectMapper =  new ObjectMapper(jsonFactory);

    @Override
    public List<T> retrieve_all() {
        String url_req = getUrlRequest();
        List<T> objList = new ArrayList<>();

        try {
            logger.debug("using URL " + url_req);
            URL url = new URL(url_req);

            InputStream is = url.openStream();
            String content = new String(IOUtils.toByteArray(is), "US-ASCII");
            objList = build(content);
        }
        catch (Exception e) {
            if (logger.isDebugEnabled()) {
                logger.debug(e.getStackTrace().toString());
            }
            logger.error("error occurred while retrieving " + e.getMessage());
        }

        return objList;
    }

    /**
     * Builds the objects using a JSON assuming that the string is a JSON array.
     * if this is not the case then override this method to meet your requirements.
     *
     * @param json
     * @return deserialised objects from JSON string.
     * @throws Exception
     */
    @Override
    public List<T> build(String json) throws Exception {

        List<T> objList = new ArrayList<>();
        JsonParser jsonParser = jsonFactory.createParser(json);
        MappingIterator<T> it = objectMapper.readValues(jsonParser, getClassT());

        if (it.hasNext()) {
            T[] attributes = (T[]) it.next();

            for (T attribute : attributes) {
                objList.add(attribute);
            }
        }

        return objList;
    }
}
