package com.nju.agile.blog.service.impl;

import com.nju.agile.blog.entity.User;
import com.nju.agile.blog.mapper.UserMapper;
import com.nju.agile.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shanhe
 * @className IUserService
 * @date 2020-02-10 23:05
 **/
@Service
public class IUserService implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public Integer saveUser(User user) {
        return null;
    }

    @Override
    public Integer deleteByUserId(String userId) {
        return null;
    }

    @Override
    public Integer modifyUser(User user) {
        return null;
    }

    @Override
    public User findByUserId(String userId) {
        return null;
    }

    @Override
    public User findByName(String userName) {
        return null;
    }

    @Override
    public User findByNameOrEmail(String string) {
        return null;
    }

    @Override
    public List<User> listUser() {
        return null;
    }
}
