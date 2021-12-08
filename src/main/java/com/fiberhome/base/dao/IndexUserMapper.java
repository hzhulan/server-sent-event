package com.fiberhome.base.dao;

import com.fiberhome.base.model.IndexUser;
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
public interface IndexUserMapper {

    /**
     * 插入
     * @param user
     */
    void insertUserInfo(@Param("user") IndexUser user);
}
