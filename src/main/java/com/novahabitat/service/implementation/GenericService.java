package com.novahabitat.service.implementation;

import com.novahabitat.exception.ModelNotFoundException;
import com.novahabitat.repository.IGenericRepository;
import com.novahabitat.service.IGenericService;

import java.util.List;

public abstract class GenericService<T, ID> implements com.novahabitat.service.IGenericService<T, ID> {
    protected abstract IGenericRepository<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        // VALIDACION DE ID MAS ADELANTE
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        // return getRepo().findById(id).orElse(null);
        return getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }
}
