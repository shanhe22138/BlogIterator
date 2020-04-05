package com.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shanhe
 * @className User
 * @date 2020-03-09 13:32
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 7481116628142801592L;

    private Integer userId;

    private String userPhoneNumber;

    private String userEmail;

    private String userPassword;

    private String userNickname;

    /**
     * userType表示两种用户身份，1为普通用户，0为管理员
     */
    private Integer userType;

    private String userAvatar;

    private Date userRegisterTime;

    private Date userLastLoginTime;

    private Integer userStatus;
}
