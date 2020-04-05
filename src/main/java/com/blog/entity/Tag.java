package com.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shanhe
 * @className Tag
 * @date 2020-03-12 22:52
 **/
@Data
public class Tag implements Serializable {
    private static final long serialVersionUID = 4896869621607870359L;

    private Integer tagId;

    private String tagName;


}
