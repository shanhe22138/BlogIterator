package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: ArticleCategoryRef
 * @description <p>表示文章和种类的一对一关系</p>
 * @author shanhe
 * @date 2020.2.9
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCategoryRef implements Serializable {

    private static final long serialVersionUID = -5870540293924093384L;

    private Integer articleId;

    private Integer categoryId;

}
