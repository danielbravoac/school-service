package com.danielbravoac.schoolservice.service;

import java.util.List;

public interface ICRUD<T, ID, P> {
    T save(T t) throws Exception;

    T update(ID id, T t) throws Exception;

    List<T> findAll() throws Exception;

    void delete(ID id) throws Exception;

    List<P> findAllProjection() throws Exception;
}
