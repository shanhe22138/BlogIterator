package com.blog.Mapper;


import com.blog.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * @author shanhe
 * @className UserMapperTest
 * @date 2020-03-10 10:24
 **/
public class UserMapperTest {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig.xml");
    private UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

    @Test
    public void selectByPhoneNumOrEmail() throws IOException {
        System.out.println(userMapper.selectByPhoneNumOrEmail("1"));
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(null);
        HashMap<String, Object> hashMap = new HashMap();
        hashMap.put(null, new Date());
        System.out.println(hashSet.add(null));
        System.out.println(hashMap.put(null, new Date()));
    }

    @Test
    public void addUser() throws IOException {
        User user = new User();
        user.setUserEmail("1234@123.com");
        user.setUserPassword("123");
        user.setUserType(1);
        userMapper.insertUser(user);
        System.out.println(user);
    }
}