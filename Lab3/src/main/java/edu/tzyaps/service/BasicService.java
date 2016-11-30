package edu.tzyaps.service;

import edu.tzyaps.dao.AbstractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Max on 30.11.2016.
 */
@Service("basicService")
@Transactional(readOnly = false)
public class BasicService<T> {

    @Autowired
    private AbstractDao dao;

    private Class<T> type;

    public BasicService() {
    }

    public BasicService(Class<T> type) {
        this.type = type;
    }

    public T getById(Integer id) {
        return (T) dao.getById(id, type);
    }

    public List<T> getAll() {
        return dao.findAll(type);
    }

    public T create(T entity) {
        return (T) dao.create(entity);
    }

    public T update(T entity) {
        return (T) dao.update(entity);
    }

    public void delete(T entity) {
        dao.delete(entity);
    }

    public void deleteById(Integer id) {
        dao.delete(dao.getById(id, type));
    }
}
