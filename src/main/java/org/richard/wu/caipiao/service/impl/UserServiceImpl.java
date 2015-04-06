package org.richard.wu.caipiao.service.impl;

import org.richard.wu.caipiao.bo.User;
import org.richard.wu.caipiao.dao.UserDao;
import org.richard.wu.caipiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richard on 4/4/2015.
 */
@Service("userService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class, readOnly=false)
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(long id) throws Exception {
        return userDao.getUser(id);
    }
}
