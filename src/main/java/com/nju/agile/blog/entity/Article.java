package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @className: Article
 * @description: 微博中的文章实体
 * @author: shanhe
 * @date: 2020-02-09 21:27
 * @version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    private static final long serialVersionUID = 1075029614003928638L;

    private Integer articleId;

    private Integer articleUserId;

    private String articleTitle;

    private Integer articleViewCount;

    private Integer articleCommentCount;

    private Integer articleLikeCount;

    private Date articleCreateTime;

    private Date articleUpdateTime;

    //作用未知
    private Integer articleIsComment;

    private Integer articleStatus;

    private Integer articleOrder;

    private String articleContent;

    /**
     * 放在最前面的总结
     */
    private String articleSummary;

    /*
    以下是非数据库内属性
     */
    private User user;

    private List<Tag> tagList;

    private List<Category> categoryList;

}
