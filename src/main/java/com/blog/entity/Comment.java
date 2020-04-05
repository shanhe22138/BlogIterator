package com.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shanhe
 * @className Comment
 * @date 2020-03-15 14:57
 **/
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = 4401067159736819735L;

    private Integer commentId;

    private Integer userId;
    /**
     * TODO
     * 数据库重构以后userName这个属性可以删了
     */
    private String userName;

    private Integer articleId;

    private Integer commentPid;

    private Integer commentTargetId;

    private String commentTargetName;

    private Date commentCreateTime;

    private String commentContent;

    /**
     * 非数据库字段
     */

    private User user;

}
