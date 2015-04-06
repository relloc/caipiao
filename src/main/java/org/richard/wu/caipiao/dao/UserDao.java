package org.richard.wu.caipiao.dao;

import org.richard.wu.caipiao.bo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Richard on 4/4/2015.
 */

@Repository
public class UserDao {
    Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User getUser(long id) throws Exception{
        try {
            logger.info("-------------------before sql 1-----------");
            jdbcTemplate.update("UPDATE  `user` SET `id`='4' WHERE `id`='2'; ");
//            int a = 10/0;//异常出现了！（如要测试则取消改行注释）
            jdbcTemplate.update("UPDATE  `user` SET `id`='6' WHERE `id`='3'; ");
            logger.info("-------------------after sql 2 -----------");
        }catch (Exception e){
            logger.info("发现异常，抛出异常才能回滚操作");
            throw new SQLException( "发现SQL异常，回滚DB操作");

        }
        User user = new User();
        user.setId(id);
        user.setName("哈哈哈哈");
        return user;
    }

    public Object getObject() {
        jdbcTemplate.queryForObject("",User.class);
        return null;
    }

}
