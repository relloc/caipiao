package org.richard.wu.caipiao.dao;

import org.richard.wu.caipiao.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

/**
 * Created by richard.wu on 4/17/2015.
 */
@Component("userDao")
public interface UserDao extends JpaRepository<User, Integer> {
    //custom method
    Integer deleteByName(String name);
}
