package com.fiberhome.base.controller;

import com.fiberhome.base.model.User;
import com.fiberhome.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: 用户
 * @author: pp_lan
 * @date: 2021/8/29 11:02
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public List<User> queryUsers() {
        return userService.queryUsers();
    }
}
