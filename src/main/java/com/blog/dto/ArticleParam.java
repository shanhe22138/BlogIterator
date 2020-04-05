package com.blog.dto;

import lombok.Data;

import java.util.List;

/**
 * @author shanhe
 * @className ArticleParam
 * @date 2020-03-13 00:22
 **/
@Data
public class ArticleParam {

    private Integer articleId;

    private String articleTitle;

    private String articleContent;

    private List<String> tags;


}
