package org.richard.wu.caipiao.dao.impl;

import org.richard.wu.caipiao.dao.BaseDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by richard.wu on 4/17/2015.
 */

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<T> findAll() {
        List<T> result = null;
        try {
            Query query = entityManager.createQuery(" from User");
            result = query.getResultList();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Object findById(Class<T> clazz, int id) {
        T result = null;
        try {
            result = entityManager.find(clazz, id);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean save(Object entity) {
        boolean result = false;
        try {
            entityManager.persist(entity);
            result = true;
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Object entity) {
        boolean result = false;
        try {
            entityManager.merge(entity);
            result = true;
        }catch ( Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Object entity) {
        boolean result = false;
        try {
            entityManager.remove(entity);
            result = true;
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return result;
    }
}
