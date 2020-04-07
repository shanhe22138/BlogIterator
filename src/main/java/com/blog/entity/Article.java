package com.blog.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author shanhe
 * @className Article
 * @date 2020-03-12 16:09
 **/
@Data
public class Article implements Serializable {
    private static final long serialVersionUID = 2378082191199107L;

    private Integer articleId;

    private Integer userId;

    private String articleTitle;

    private String articleContent;

    private Integer articleViewCount;

    private Date articleCreateTime;

    private Date articleUpdateTime;

    /**
     * TODO
     * 属性没啥用，下次删掉
     */
    private boolean articleIsComment;

    /**
     * 1表示正常，0表示禁用
     */
    private Integer articleStatus;

    private String articleSummary;

    /**
     * 一下为非数据库属性
     */
    private User user;

    private List<Tag> tags;

    private Integer articleCommentCount;


}
