package edu.tzyaps.dao;

import java.util.List;

/**
 * Created by Max on 07.08.2016.
 */
public interface AbstractDao<T> {

    T getById(Integer id, Class<T> type);

    List<T> findAll(Class<T> type);

    T create(T entity);

    T update(T entity);

    void delete(T entity);
}
