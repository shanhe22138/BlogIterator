package com.nju.agile.blog.service;

import com.nju.agile.blog.entity.User;

import java.util.List;

/**
 * @author shanhe
 * @className UserService
 * @date 2020-02-10 22:54
 **/
public interface UserService {

    /**
    * TODO 增加用户
    * @param user 用户
    * @return java.lang.Integer
    * @author shanhe
    * @date 2020/2/10 11:02 下午
    **/
    public Integer saveUser(User user);

    /**
    * TODO 根据用户id删除用户
    * @param userId 用户id
    * @return java.lang.Integer
    * @author shanhe
    * @date 2020/2/10 11:02 下午
    **/
    public Integer deleteByUserId(String userId);

    /**
    * TODO 修改用户信息
    * @param user 用户
    * @return java.lang.Integer
    * @author shanhe
    * @date 2020/2/10 11:03 下午
    **/
    public Integer modifyUser(User user);

    /**
    * TODO 根据用户id查找用户
    * @param userId 用户id
    * @return com.nju.agile.blog.entity.User
    * @author shanhe
    * @date 2020/2/10 11:03 下午
    **/
    public User findByUserId(String userId);

    /**
    * TODO 根据用户名查找用户
    * @param userName 用户名
    * @return com.nju.agile.blog.entity.User
    * @author shanhe
    * @date 2020/2/10 11:03 下午
    **/
    public User findByName(String userName);

    /**
    * TODO 根据用户名或注册邮箱查找用户
    * @param string 用户名或注册邮箱
    * @return com.nju.agile.blog.entity.User
    * @author shanhe
    * @date 2020/2/10 11:04 下午
    **/
    public User findByNameOrEmail(String string);

    /**
    * TODO 列出所有用户
    * @return java.util.List<com.nju.agile.blog.entity.User>
    * @author shanhe
    * @date 2020/2/10 11:04 下午
    **/
    public List<User> listUser();
}
