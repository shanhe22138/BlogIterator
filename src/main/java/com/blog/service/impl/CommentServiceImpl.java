package com.blog.service.impl;

import com.blog.Mapper.CommentMapper;
import com.blog.Mapper.UserMapper;
import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shanhe
 * @className CommentServiceImpl
 * @date 2020-03-16 14:28
 **/
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    private void completeComment(Comment comment) {
        User user = userMapper.selectById(comment.getUserId());
        int num = commentMapper.countCommentedNum(comment.getCommentId());
        if(num > 0) {
            comment.setCommented(true);
        } else {
            comment.setCommented(false);
        }
        comment.setUser(user);
    }

    @Override
    public Integer saveComment(Comment comment) {

        commentMapper.insert(comment);
        return null;
    }

    @Override
    public List<Comment> findByArticleId(Integer id) {
        List<Comment> comments = commentMapper.selectCommentByArticleId(id);
        for (Comment c:
             comments) {
            completeComment(c);
        }
        return comments;
    }

    @Override
    public List<Comment> findReplay(Integer commentPid) {
        List<Comment> comments = commentMapper.findByCommentPid(commentPid);
        for (Comment c :
                comments) {
            completeComment(c);
        }
        return comments;
    }

    @Override
    public void removeById(int id) {
        commentMapper.deleteById(id);
    }


}
