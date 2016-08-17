package org.azzasurf.model.actions;

import java.util.HashMap;
import java.util.List;

/**
 * Created by aaron.spiteri on 15/08/2016.
 */
public interface Crud <T> {

    /**
     * Create a new attribute
     *
     * @param element
     * @return created element
     */
    T create(T element);

    /**
     * Retrieve element based upon params given.
     * NULL is returned if nothing can be found.
     *
     * @param params
     * @return array of matching elements
     */
    List<T> retrieve(HashMap<String, Object> params);

    /**
     * Retrieve all elements that have not been deleted.
     *
     * @return all elments
     */
    List<T> retrieve_all();

    /**
     * Update a specfic element, return the updated element.
     *
     * @param element
     * @return updated element
     */
    T update(T element);

    /**
     * Remove element.
     *
     * @param element
     * @return true if removed otherwise false.
     */
    boolean delete(T element);
}
