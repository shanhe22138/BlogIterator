package com.nju.agile.blog.mapper;

import com.nju.agile.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.checkerframework.checker.units.qual.A;

import java.util.HashMap;
import java.util.List;

/**
 * @className: ArticleMapper
 * @description: <p>article的dao层接口</p>
 * @author: shanhe
 * @date: 2020-02-09 22:02
 * @version: 1.0
 **/
@Mapper
public interface ArticleMapper {

    Integer insert();

    Integer deleteById(Integer articleId);

    /**
    * TODO 批量删除文章
    * @param ids id集合
    * @return java.lang.Integer
    * @author shanhe
    * @date 2020/2/11 8:46 下午
    **/
    Integer deleteBatch(@Param("ids") List<Integer> ids);

    Integer update(Article article);

    /**
    * TODO 更新某篇文章的评论数量
    * @param articleId 文章id
    * @return java.lang.Integer
    * @author shanhe
    * @date 2020/2/11 8:54 下午
    **/
    Integer updateArticleCommentCount(Integer articleId);

    Article selectByIdAndStatus(@Param("id") Integer articleId,//当参数个数大于1时使用@Param注解，以标示sql语句中的参数，此时使用${}进行替换
                                    @Param("status") Integer status);

    /**
    * TODO 获取下一篇文章
    * @param id 文章id
    * @return com.nju.agile.blog.entity.Article
    * @author shanhe
    * @date 2020/2/11 8:49 下午
    **/
    Article nextArticle(Integer id);

    /**
    * TODO 获取上一片文章
    * @param id 文章id
    * @return com.nju.agile.blog.entity.Article
    * @author shanhe
    * @date 2020/2/11 8:49 下午
    **/
    Article preArticle(Integer id);

    Article selectLastUpdateArticle();

    List<Article> listAll();

    /**
    * TODO 根据条件查询文章
    * @param condition 查询条件
    * @return java.util.List<com.nju.agile.blog.entity.Article>
    * @author shanhe
    * @date 2020/2/11 8:45 下午
    **/
    List<Article> listAllByCondition(HashMap<String, Object> condition);

    /**
    * TODO
    * 文章归档
    * @return java.util.List<com.nju.agile.blog.entity.Article>
    * @author shanhe
    * @date 2020/2/11 8:44 下午
    **/
    List<Article> listAllWithoutContent();

    /**
    * TODO 列出viewcount最多的文章，实现猜你喜欢的功能
    * @param limit 本次列出的数量
    * @return java.util.List<com.nju.agile.blog.entity.Article>
    * @author shanhe
    * @date 2020/2/11 8:43 下午
    **/
    List<Article> listArticleByViewCount(Integer limit);

    /**
    * TODO 随机获取limit个文章
    * @param limit 文章数量
    * @return java.util.List<com.nju.agile.blog.entity.Article>
    * @author shanhe
    * @date 2020/2/11 8:51 下午
    **/
    List<Article> listRandomArticle(Integer limit);

    /**
    * TODO 获取limit个热评文章
    * @param limit 文章数量
    * @return java.util.List<com.nju.agile.blog.entity.Article>
    * @author shanhe
    * @date 2020/2/11 8:52 下午
    **/
    List<Article> listArticleByCommentCount(Integer limit);

    /**
    * TODO 列出某个种类的limit个文章
    * @param categoryId 种类id
    * @param limit 数量
    * @return java.util.List<com.nju.agile.blog.entity.Article>
    * @author shanhe
    * @date 2020/2/11 9:00 下午
    **/
    List<Article> selectArticleByCategoryId(@Param("id") Integer categoryId, @Param("limit") Integer limit);

    /**
    * TODO 列出某些种类的limit个文章
    * @param ids id列表
    * @param limit 数量
    * @return java.util.List<com.nju.agile.blog.entity.Article>
    * @author shanhe
    * @date 2020/2/11 9:03 下午
    **/
    List<Article> selectArticleByCategoryIds(@Param("ids") List<Integer> ids, @Param("limit") Integer limit);

    /**
    * TODO 列出最新的limit个文章
    * @param limit 数量
    * @return java.util.List<com.nju.agile.blog.entity.Article>
    * @author shanhe
    * @date 2020/2/11 9:04 下午
    **/
    List<Article> listNewestArticle(Integer limit);

    /**
    * TODO
    * 计算博客中的文章总数
    * @return java.lang.Integer
    * @author shanhe
    * @date 2020/2/11 8:46 下午
    **/
    Integer countArticle(Integer status);

    Integer countArticleComment();

    Integer countArticleView();

    Integer countArticleByUser(Integer userId);

    List<Article> pageArticle(@Param("status") Integer status,
                                @Param("pageIndex") Integer pageIndex,
                                    @Param("pageSize") Integer pageSize);



}
