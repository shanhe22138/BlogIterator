package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @className: Page
 * @description: <p>页面信息</p>
 * @author: shanhe
 * @date: 2020-02-09 21:54
 * @version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page implements Serializable {
    private static final long serialVersionUID = -7607065522311458796L;

    private Integer pageId;

    private String pageKey;

    private String pageTitle;

    private String pageContent;

    private Date pageCreateTime;

    private Date pageUpdateTime;

    private Integer pageViewCount;

    private Integer pageCommentCount;

    private Integer pageStatus;
}
