package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * The entity of User.
 *
 *
 * @className User
 * @description <p>Description: 用户实体类，第二次迭代的时候需要对用户和数据库进行更改，以让非管理员用户能够登陆</p>
 * @author shanhe
 * @date 2020-02-09 21:32
 * @version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 6952953368425086110L;

    private Integer userId;

    private String userName;

    private String userPass;

    private String userNickname;

    private String userEmail;

    private String userUrl;

    private String userAvatar;

    private String userLastLoginIp;

    private Date userRegisterTime;

    private Date userLastLoginTime;

    private Integer userStatus;

    /**
     * 文章数量（不是数据库字段）
     */
    private Integer articleCount;
}
