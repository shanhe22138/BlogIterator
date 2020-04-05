package com.blog.service;

import com.blog.entity.User;

/**
 * @author shanhe
 * @className IUserService
 * @date 2020-03-09 14:25
 **/

public interface IUserService {
    Integer addUser(User user);

    User findByPhoneNumOrEmail(String s);

    void update(User user);
}
