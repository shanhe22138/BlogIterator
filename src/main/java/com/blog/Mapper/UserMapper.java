package com.blog.Mapper;

import com.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shanhe
 * @className UserMapper
 * @date 2020-03-09 14:33
 **/
@Mapper
public interface UserMapper {
    Integer insertUser(User user);

    User selectByPhoneNumOrEmail(String s);

    User selectById(Integer userId);

    void update(User user);
}
