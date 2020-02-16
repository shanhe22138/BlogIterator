package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @className: Link
 * @description: <p>左下角外部链接实体类</p>
 * @author: shanhe
 * @date: 2020-02-09 21:59
 * @version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link implements Serializable {
    private static final long serialVersionUID = -4761415254340290106L;

    private Integer linkId;

    private String linkUrl;

    private String linkName;

    private String linkImage;

    private String linkDescription;

    private String linkOwnerNickname;

    private String linkOwnerContact;

    private Date linkUpdateTime;

    private Date linkCreateTime;

    private Integer linkOrder;

    private Integer linkStatus;
}
