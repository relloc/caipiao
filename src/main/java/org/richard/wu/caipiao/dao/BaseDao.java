package org.richard.wu.caipiao.dao;

import java.util.List;

/**
 * Created by richard.wu on 4/17/2015.
 */
public interface BaseDao<T> {

    List<T> findAll();

    Object findById(Class<T> clazz, int id);

    boolean save(Object entity);

    boolean update(Object entity);

    boolean delete(Object entity);

}

