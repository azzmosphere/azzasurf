package org.azzasurf.model.actions;

import java.util.Map;

/**
 * Created by aaron.spiteri on 17/08/2016.
 */
public interface JSONCrud<T> extends Crud<T> {
    T build(Map<String, Object> map) throws Exception;

    String getUrlRequest();
}
