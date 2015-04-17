package org.richard.wu.caipiao.service.impl;

import org.richard.wu.caipiao.bo.User;
import org.richard.wu.caipiao.dao.BaseDao;
import org.richard.wu.caipiao.dao.UserDao;
import org.richard.wu.caipiao.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by richard.wu on 4/17/2015.
 */
@Service("baseService")
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    @Autowired
    private UserDao userDao;

    public Integer deleteByname(String name) {

        return userDao.deleteByName(name);
    }

    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<T> findAll() {
        return baseDao.findAll();
    }

    @Override
    public Object findById(Class<T> clazz, int id) {
        return baseDao.findById(clazz, id);
    }

    @Override
    public boolean save(Object entity) {
        return baseDao.save(entity);
    }

    @Override
    public boolean update(Object entity) {
        return baseDao.update(entity);
    }

    @Override
    public boolean delete(Object entity) {
        return baseDao.delete(entity);
    }
}
