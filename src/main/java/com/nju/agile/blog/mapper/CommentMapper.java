package com.nju.agile.blog.mapper;

import com.nju.agile.blog.entity.Comment;

import java.util.List;

/**
 * @author shanhe
 * @className CommentMapper
 * @date 2020-02-12 15:29
 **/
public interface CommentMapper {

    Integer insert(Comment comment);

    Integer deleteById(Integer commentId);

    void update(Comment comment);

    Comment selectCommentById(Integer commentId);

    List<Comment> selectByArticleId(Integer articleId);

    /**
    * TODO
    * 这可能也是个重复接口，待查
    * @return java.util.List<com.nju.agile.blog.entity.Comment>
    * @author shanhe
    * @date 2020/2/12 3:37 下午
    **/
    List<Comment> listComment();

    List<Comment> listRecentComment();

    List<Comment> listChildComment();

    /**
    * TODO
    * 计算全部评论的数量，这应该是个重复代码，二次迭代的时候看看能不能删掉
    * @return java.lang.Integer
    * @author shanhe
    * @date 2020/2/12 3:34 下午
    **/
    Integer countComment();

}
