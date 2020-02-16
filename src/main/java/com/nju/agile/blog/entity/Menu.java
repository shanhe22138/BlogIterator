package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: Menu
 * @description: <p>右上角菜单实体</p>
 * @author: shanhe
 * @date: 2020-02-09 21:58
 * @version:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {
    private static final long serialVersionUID = 6553130566436466448L;

    private Integer menuId;

    private String menuName;

    private String menuUrl;

    private Integer menuLevel;

    private String menuIcon;

    private Integer menuOrder;
}
