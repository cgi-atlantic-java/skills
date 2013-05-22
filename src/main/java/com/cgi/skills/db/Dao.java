package com.cgi.skills.db;

/**
 * TODO: Document this
 */
public interface Dao<I, E> {

    void persist(E entity);

    void remove(E entity);

    E findById(I id);

    Iterable<E> findAll();
}
