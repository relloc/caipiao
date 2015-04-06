package org.richard.wu.caipiao.service;

import org.richard.wu.caipiao.bo.User;
import org.richard.wu.caipiao.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Richard on 4/4/2015.
 */
public interface UserService {


    User getUser(long id) throws Exception;
}
