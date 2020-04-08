package com.blog.service;

import com.blog.entity.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author shanhe
 * @className IArticleMapper
 * @date 2020-03-12 23:37
 **/
public interface IArticleService {

    Integer save(Article article);

    PageInfo<Article> findByPage(int pageNum, Integer pageSize);

    Article findById(Integer id);

    void addViewCount(Integer id);

    PageInfo<Article> findByUserId(Integer userId, Integer pageNum, Integer pageSize);

    PageInfo<Article> findPageByQuery(String query, Integer pageNum, Integer pageSize);
}
