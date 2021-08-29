package com.fiberhome.base.dao;

import com.fiberhome.base.model.User;

import java.util.List;

/**
 * @description:
 * @author: pp_lan
 * @date: 2021/8/29 9:11
 */
public interface UserDao {

    List<User> queryUsers();
}
