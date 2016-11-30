package edu.tzyaps.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Max on 07.08.2016.
 */
@Repository("abstractDaoImpl")
public class AbstractDaoImpl<T> implements AbstractDao<T> {

    @Autowired
    protected HibernateTemplate ht;

    public T getById(Integer id, Class<T> type) {
        return ht.get(type, id);
    }

    public List<T> findAll(Class<T> type) {
        return ht.loadAll(type);
    }

    public T create(T entity) {
        ht.save(entity);
        return entity;
    }

    public T update(T entity) {
        ht.getSessionFactory().getCurrentSession().clear(); // TODO: 08.08.2016 Why i am do this ?
        ht.saveOrUpdate(entity);
        return entity;
    }

    public void delete(T entity) {
        ht.delete(entity);
    }
}
