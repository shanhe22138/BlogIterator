package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: Tag
 * @description: <p>标签实体类</p>
 * @author: shanhe
 * @date: 2020-02-09 21:31
 * @version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag implements Serializable {
    private static final long serialVersionUID = 5595220992858496440L;

    private Integer tagId;

    private String tagName;

    private String tagDescription;

    /**
     * 文章数量(不是数据库字段)
     */
    private Integer articleCount;

    public Tag(Integer tagId) {
        this.tagId = tagId;
    }
}
