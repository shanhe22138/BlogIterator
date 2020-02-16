package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: AtricleTagRef
 * @description <p>表示数据库中文章和标签的一对多关系。但base中的对应关系是1对1，应该在第二次迭代中进行修改</p>
 * @author shanhe
 * @date 2020.2.9
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtricleTagRef implements Serializable {

    private static final long serialVersionUID = 6508027174413022727L;

    private Integer articleId;

    private Integer tagId;

}
