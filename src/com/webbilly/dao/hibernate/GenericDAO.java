package com.webbilly.dao.hibernate;

import com.webbilly.dao.IGenericDAO;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.Collection;

public class GenericDAO<T> extends HibernateDaoSupport implements IGenericDAO<T> {

    /**
     * ******************************************************
     * ********* Accessors and private members ****************
     * *******************************************************
     */

    private Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    public T getById(int id) {
        return (T) getHibernateTemplate().get(type, id);
    }

    public Collection<T> getAll() {
        return getHibernateTemplate().loadAll(type);
    }

    public void save(T t) {
        getHibernateTemplate().saveOrUpdate(t);
    }

    public void delete(int id) {
        getHibernateTemplate().delete(getById(id));
    }

}
