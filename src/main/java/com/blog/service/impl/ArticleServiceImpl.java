package com.blog.service.impl;

import com.blog.Mapper.ArticleMapper;
import com.blog.Mapper.CommentMapper;
import com.blog.Mapper.TagMapper;
import com.blog.Mapper.UserMapper;
import com.blog.entity.Article;
import com.blog.service.IArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author shanhe
 * @className ArticleMapperImpl
 * @date 2020-03-12 23:39
 **/
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TagMapper tagMapper;

    private void completeArticle(Article article) {
        if(article.isArticleIsComment()) {
            article.setArticleCommentCount(commentMapper.countByIArticled(article.getArticleId()));
        } else {
            article.setArticleCommentCount(0);
        }

        article.setTags(tagMapper.selectById(article.getArticleId()));

        article.setUser(userMapper.selectById(article.getUserId()));

    }

    @Override
    public Integer save(Article article) {

        article.setArticleUpdateTime(new Date());

        return articleMapper.insert(article);
    }

    @Override
    public PageInfo<Article> findByPage(int pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ArrayList<Article> articles = articleMapper.selectAll();
        for(Article article :
            articles) {
            //封装标签，可使用SQL优化
            //优化思路是取出所有articleID，然后一次性查出所有标签，再以空格分割标签，以"，"分割文章
            //返回一个字符串再做操作
            completeArticle(article);
        }
        return new PageInfo<>(articles);
    }

    @Override
    public Article findById(Integer id) {
        Article article = articleMapper.selectById(id);

        completeArticle(article);

        return article;
    }

    @Override
    public void addViewCount(Integer id) {
        articleMapper.addViewCount(id);
    }

}
