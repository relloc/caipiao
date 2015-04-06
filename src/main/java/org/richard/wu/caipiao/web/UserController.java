package org.richard.wu.caipiao.web;


import org.richard.wu.caipiao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.richard.wu.caipiao.bo.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object view(@PathVariable("id") Long id) throws Exception{
        User user = userService.getUser(id);
        logger.info("=============UserController -===============--");
        return user;
    }

    @PostConstruct
    public void postConstruct() {

    }

    @PreDestroy
    public void preDestroy() {

    }
}

