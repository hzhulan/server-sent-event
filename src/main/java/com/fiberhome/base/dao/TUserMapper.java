package com.fiberhome.base.dao;

import com.fiberhome.base.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: pp_lan
 * @date: 2021/9/8 7:26
 */
@Repository
public interface TUserMapper {

    void insertUserInfo(@Param("user") User user);

    List<User> selectByName(@Param("name") String name);

    List<User> searchByName(@Param("name") String name);
}
