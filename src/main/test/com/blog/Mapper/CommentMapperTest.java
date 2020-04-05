package com.blog.Mapper;

import com.blog.entity.Comment;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shanhe
 * @className CommentMapperTest
 * @date 2020-04-05 10:05
 **/
public class CommentMapperTest {
    
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig.xml");
    private CommentMapper mapper = (CommentMapper) applicationContext.getBean("commentMapper");
    

    @Test
    public void selectCommentByArticleId() {
        List<Comment> list = mapper.selectCommentByArticleId(1);
        System.out.println(list);
    }
}