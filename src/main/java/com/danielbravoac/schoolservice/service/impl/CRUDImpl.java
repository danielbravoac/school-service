package com.danielbravoac.schoolservice.service.impl;

import com.danielbravoac.schoolservice.exception.custom.ModelNotFoundException;
import com.danielbravoac.schoolservice.repository.IGenericRepo;
import com.danielbravoac.schoolservice.service.ICRUD;

import java.lang.reflect.Method;
import java.util.List;

public abstract class CRUDImpl<T, ID, P> implements ICRUD<T, ID, P> {

    protected abstract IGenericRepo<T, ID, P> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        Class<?> clazz = t.getClass();
        String className = clazz.getSimpleName();
        String methodName = "setId" + className;
        Method setIdMethod = clazz.getMethod(methodName, id.getClass());
        setIdMethod.invoke(t, id);

        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID " + id + " not found"));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID " + id + " not found"));
        getRepo().deleteById(id);
    }

    @Override
    public List<P> findAllProjection() throws Exception {
        return getRepo().findAllBy();
    }
}
