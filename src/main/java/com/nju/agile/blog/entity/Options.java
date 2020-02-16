package com.nju.agile.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: Options
 * @description: <p>实体待确认</p>
 * @author: shanhe
 * @date: 2020-02-09 21:55
 * @version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Options implements Serializable {

    private static final long serialVersionUID = -1189318971334841336L;

    private Integer optionId;

    private String optionSiteTitle;

    private String optionSiteDescrption;

    private String optionMetaDescrption;

    private String optionMetaKeyword;

    private String optionAboutsiteAvatar;

    private String optionAboutsiteTitle;

    private String optionAboutsiteContent;

    private String optionAboutsiteWechat;

    private String optionAboutsiteQq;

    private String optionAboutsiteGithub;

    private String optionAboutsiteWeibo;

    private String optionTongji;

    private Integer optionStatus;
}
