package com.ibm.internship.onlineshop.facade.convertor;

public interface Convertor<T,U> {

    U convert(T item);

}
