package com.fiberhome.base;

import com.fiberhome.base.dao.IndexUserMapper;
import com.fiberhome.base.model.IndexUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.net.SecureCacheResponse;
import java.security.SecureRandom;

/**
 * @description:
 * @author: pp_lan
 * @date: 2021/10/26 19:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/spring-content.xml",
        "classpath:spring/spring-mvc.xml"
})
@WebAppConfiguration
public class IndexTest {

    @Resource
    private IndexUserMapper indexUserMapper;
    /**
     CREATE TABLE "public"."t_test" (
     "id" int4 NOT NULL,
     "name" varchar(50) COLLATE "pg_catalog"."default",
     "desc" varchar(50) COLLATE "pg_catalog"."default",
     "age" int4,
     "sort" int4,
     CONSTRAINT "t_test_pkey" PRIMARY KEY ("id")
     )
     ;

     ALTER TABLE "public"."t_test"
     OWNER TO "postgres";

     CREATE INDEX "index_test_age" ON "public"."t_test" USING btree (
     "age" "pg_catalog"."int4_ops" ASC NULLS LAST
     );

     CREATE INDEX "index_test_name" ON "public"."t_test" USING btree (
     "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
     );

     CREATE INDEX "index_test_sort" ON "public"."t_test" USING btree (
     "sort" "pg_catalog"."int4_ops" ASC NULLS LAST
     );
     */
    @Test
    public void create() {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 100000; i++) {
            int ageIncrease = random.nextInt(10);
            indexUserMapper.insertUserInfo(new IndexUser(i, "张三"+i, "张三的小号", 20 + ageIncrease, i));
        }
    }
}
