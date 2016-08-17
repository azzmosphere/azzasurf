package org.azzasurf.model.actions;

import java.util.List;

/**
 * Created by aaron.spiteri on 17/08/2016.
 */
public interface JSONCrud<T> extends Crud<T> {
    List<T> build(String json) throws Exception;

    String getUrlRequest();

    Class getClassT();
}
