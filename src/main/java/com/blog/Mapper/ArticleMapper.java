package com.blog.Mapper;

import com.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shanhe
 * @className ArticleMapper
 * @date 2020-03-12 23:40
 **/
@Mapper
public interface ArticleMapper {
    Integer insert(Article article);

    ArrayList<Article> selectAll();

    Article selectById(Integer id);

    void addViewCount(Integer id);

    List<Article> selectByUserId(Integer userId);

    List<Article> selectByQuery(String query);
}
