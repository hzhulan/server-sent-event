package com.fiberhome.base;

import com.fiberhome.base.dao.TUserMapper;
import com.fiberhome.base.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: pp_lan
 * @date: 2021/8/29 9:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/spring-content.xml",
        "classpath:spring/spring-mvc.xml"
})
@WebAppConfiguration
public class UserTest {

    @Resource
    private TUserMapper tUserMapper;

    @Test
    public void test() {

        for (int i = 1; i < 10; i++) {
            tUserMapper.insertUserInfo(new User(i, 20, "li" + i));
        }

    }

    /**
     * 有sql注入危险示例
     */
    @Test
    public void test02() {

        List<User> users = tUserMapper.selectByName("' or '1'='1");
        System.out.println("期望： 系统没有该用户时候，查询不到");
        Assert.assertEquals(0, users.size());

    }

    /**
     * 优化后方案
     */
    @Test
    public void test03() {

        List<User> users = tUserMapper.searchByName("' or '1'='1");
        System.out.println("期望： 系统没有该用户时候，查询不到");
        Assert.assertEquals(0, users.size());

    }

}
