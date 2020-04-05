package com.blog.Mapper;

import com.blog.entity.Article;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


/**
 * @author shanhe
 * @className ArticleMapperTest
 * @date 2020-03-13 10:59
 **/
public class ArticleMapperTest {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig.xml");
    private ArticleMapper mapper = (ArticleMapper) applicationContext.getBean("articleMapper");

    @Test
    public void insert() {
        Article article = new Article();
        article.setUserId(1);
        article.setArticleTitle("测试");
        article.setArticleContent("djiaosjfnkafsofnmp非i阿胶挖坟拍外景");
        article.setArticleSummary("sss");
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        mapper.insert(article);
    }
}