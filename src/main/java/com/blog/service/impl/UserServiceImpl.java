package com.blog.service.impl;

import com.blog.Mapper.UserMapper;
import com.blog.entity.User;
import com.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shanhe
 * @className UserServiceImpl
 * @date 2020-03-09 14:31
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public Integer addUser(User user) {
        if(findByPhoneNumOrEmail(user.getUserPhoneNumber()) != null ||
            findByPhoneNumOrEmail(user.getUserEmail()) != null) {
            return 0;
        }
        return userMapper.insertUser(user);
    }

    @Override
    public User findByPhoneNumOrEmail(String s) {
        User user = userMapper.selectByPhoneNumOrEmail(s);
        return user;
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
