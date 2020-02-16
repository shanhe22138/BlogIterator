package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: Category
 * @description: <p>article种类的实体类，与article是一对一的关系</p>
 * @author: shanhe
 * @date: 2020-02-09 21:29
 * @version: 1.1
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = 5260036069521585951L;

    private Integer categoryId;

    /**
     * pid表示类型种类，0表示大类，1，10，15分别表示某一大类中的其他小类
     */
    private Integer categoryPid;

    private String categoryName;

    private String categoryDescription;

    private Integer categoryOrder;

    private String categoryIcon;

    /**
     * 文章数量(非数据库字段)
     */
    private Integer articleCount;


    public Category(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}
