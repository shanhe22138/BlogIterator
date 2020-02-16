package com.nju.agile.blog.mapper;

import com.nju.agile.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>user类的mapper层接口</p>
 *
 * @className UserMapper
 * @author shanhe
 * @date 2020-02-10 09:27
 * @version 1.0
 **/
@Mapper
public interface UserMapper {
    /**
    * TODO 增加用户
    *
    * @param user 用户
    * @return int
    * @author shanhe
    * @date 2020/2/10 9:28 上午
    **/
    int insert(User user);

    /**
    * TODO
    * @param userId 用户id
    * @return int
    * @author shanhe
    * @date 2020/2/10 10:16 上午
    **/
    int deleteById(Integer userId);

    /**
    * TODO
    * @param user 用户
    * @return int
    * @author shanhe
    * @date 2020/2/10 10:18 上午
    **/
    int update(User user);

    /**
    * TODO
    * @param userId userId
    * @return com.nju.agile.blog.entity.User
    * @author shanhe
    * @date 2020/2/10 10:19 上午
    **/
    User getUserById(Integer userId);

    /**
    * TODO
    * @param userName 用户名
    * @return com.nju.agile.blog.entity.User
    * @author shanhe
    * @date 2020/2/10 10:20 上午
    **/
    User getUserByName(String userName);

    /**
    * TODO
    * @param email 邮箱地址
    * @return com.nju.agile.blog.entity.User
    * @author shanhe
    * @date 2020/2/10 10:21 上午
    **/
    User getUserByEmail(String email);

    /**
    * TODO
    * @param str 邮箱地址或用户名
    * @return com.nju.agile.blog.entity.User
    * @author shanhe
    * @date 2020/2/10 10:22 上午
    **/
    User getUserByNameOrEmail(String str);

    /**
    * TODO
    * @return java.util.List<com.nju.agile.blog.entity.User>
    * @author shanhe
    * @date 2020/2/10 10:22 上午
    **/
    List<User> listUser();
}
