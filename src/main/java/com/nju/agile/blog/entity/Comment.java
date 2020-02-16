package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @className: Comment
 * @description: <p>博客评论实体类</p>
 * @author: shanhe
 * @date: 2020-02-09 21:31
 * @version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    private static final long serialVersionUID = -8928024389749465471L;

    private Integer commentId;

    /**
     * pid表示被评论的人，即层主，本条评论为层主评论，则pid为0
     * 每层评论按照时间排序以显示在论坛上
     */
    private Integer commentPid;

    private String commentPname;

    private Integer commentArticleId;

    private String commentAuthorName;

    private String commentAuthorEmail;

    private String commentAuthorUrl;

    private String commentAuthorAvatar;

    private String commentContent;

    //搞不清楚这属性是干嘛的
    private String commentAgent;

    private String commentIp;

    private Date commentCreateTime;

    /**
     * 角色(管理员1)
     */
    private Integer commentRole;

    /*
     * 非数据库字段
     */
    private Article article;
}
