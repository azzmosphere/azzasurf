package org.azzasurf.model.actions;

import java.io.InputStream;
import java.util.List;

/**
 * Created by aaron.spiteri on 17/08/2016.
 */
public interface JSONCrud<T> extends Crud<T> {
    List<T> build(String json) throws Exception;

    String getUrlRequest();

    Class getClassT();

    /**
     * called by the JSONAbstractBase class when
     * @param deserialisedList
     */
    void setDeserialisedList(List<T> deserialisedList);

    /**
     * Sets the input stream, override this method if the input
     * stream is not a URL.
     *
     * @return
     * @throws Exception
     */
    InputStream getInputStream() throws Exception;
}
