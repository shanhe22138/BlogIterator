package com.blog.Mapper;

import com.blog.entity.Tag;

import java.util.List;

/**
 * @author shanhe
 * @className TagMapper
 * @date 2020-03-27 16:44
 **/
public interface TagMapper {
    List<Tag> selectById(Integer id);
}
