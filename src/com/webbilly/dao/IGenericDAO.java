package com.webbilly.dao;

import java.util.Collection;

public interface IGenericDAO<T> {
    void save(T t);

    Collection<T> getAll();

    T getById(int id);

    void delete(int id);
}
