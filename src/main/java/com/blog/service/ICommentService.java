package com.blog.service;

import com.blog.entity.Comment;

import java.util.List;

/**
 * @author shanhe
 * @className ICommentService
 * @date 2020-03-16 14:25
 **/
public interface ICommentService {
    Integer saveComment(Comment comment);

    List<Comment> findByArticleId(Integer id);

    List<Comment> findReplay(Integer commentPid);
}
