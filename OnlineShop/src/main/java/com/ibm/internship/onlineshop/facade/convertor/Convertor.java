package com.ibm.internship.onlineshop.facade.convertor;

public interface Convertor<T, U> {

    /**
     * Convert T to U
     *
     * @param item
     * @return U
     */
    U convert(T item) throws ClassNotFoundException, IllegalAccessException;


}
