package com.megvii.qa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserDaoTest {

    @Resource
    private UserMapper userMapper;

    @Test
    @Rollback(false)
    public void test(){
         User user = new User();
         user.setUserId(4);
         user.setPassword("123456");
         user.setPhone("13591758736");
         user.setUserName("mickeysunkl");
         userMapper.insert(user);
//         System.out.println("-------------插入成功");
    }

}
