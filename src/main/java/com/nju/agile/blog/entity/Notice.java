package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @className: Notice
 * @description: <p>页面顶部广播信息实体类</p>
 * @author: shanhe
 * @date: 2020-02-09 21:57
 * @version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice implements Serializable {
    private static final long serialVersionUID = -5613004046056060896L;

    private Integer noticeId;

    private String noticeTitle;

    private String noticeContent;

    private Date noticeCreateTime;

    private Date noticeUpdateTime;

    private Integer noticeStatus;

    private Integer noticeOrder;
}
