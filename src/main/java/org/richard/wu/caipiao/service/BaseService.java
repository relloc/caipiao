package org.richard.wu.caipiao.service;

import org.richard.wu.caipiao.bo.User;

import java.util.List;

/**
 * Created by richard.wu on 4/17/2015.
 */
public interface BaseService<T> {

    List<T> findAll();

    Object findById(Class<T> clazz, int id);

    boolean save(Object entity);

    boolean update(Object entity);

    boolean delete(Object entity);

    void save(User user);

    Integer deleteByname(String name);
}
