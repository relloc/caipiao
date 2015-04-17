package org.richard.wu.caipiao.web;


import org.richard.wu.caipiao.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    public BaseService baseService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") int id, Model model) throws Exception {
        User user = (User)baseService.findById(User.class, id);
        model.addAttribute("user", user);
        return "home";
    }

    @RequestMapping(value = "/del/{name}", method = RequestMethod.GET)
    public String del(@PathVariable("name") String name, Model model) throws Exception {
        baseService.deleteByname(name);
        User u = new User();
        u.setId(123);
        u.setName("newName");
        baseService.save(u);

        return "home";
    }

    @PostConstruct
    public void postConstruct() {

    }

    @PreDestroy
    public void preDestroy() {

    }
}

