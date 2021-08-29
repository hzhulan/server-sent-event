package com.fiberhome.base.service;

import com.fiberhome.base.dao.UserDao;
import com.fiberhome.base.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: pp_lan
 * @date: 2021/8/29 9:10
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public List<User> queryUsers() {
        List<User> users = userDao.queryUsers();
        return users;
    }
}
