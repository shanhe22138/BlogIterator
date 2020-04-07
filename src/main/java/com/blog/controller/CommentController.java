package com.blog.controller;

import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.service.ICommentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

/**
 * @author shanhe
 * @className CommentController
 * @date 2020-03-16 14:34
 **/
@Controller
public class CommentController {
    @Autowired
    private ICommentService service;

    @RequestMapping(value = "/comment/save", method = RequestMethod.POST)
    @ResponseBody
    public String saveComment(HttpServletRequest request) {
        //System.out.println("comment进入服务器controller");
        HttpSession session = request.getSession();
        Comment comment = new Comment();
        User user = (User)session.getAttribute("user");
        String articleId = request.getParameter("articleId"),
                commentTargetId = request.getParameter("commentTargetId"),
                    commentTargetName = request.getParameter("commentTargetName"),
                        commentContent = request.getParameter("commentContent"),
                                commentPid = request.getParameter("commentPid");
        /**
         * TODO
         * targetName有一定的冗余，需要从数据库上做更改
         */

        comment.setUserId(user.getUserId());
        comment.setArticleId(Integer.parseInt(articleId));
        comment.setCommentTargetId(Integer.parseInt(commentTargetId));
        comment.setCommentTargetName(commentTargetName);
        comment.setCommentPid(Integer.parseInt(commentPid));
        /**
         * TODO
         * 内容需要做排查，防止xss攻击
         */
        comment.setCommentContent(commentContent);
        comment.setCommentCreateTime(new Date());
        
        //System.out.println("前端数据：" + comment);
        service.saveComment(comment);

        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", 1);

        return new JSONObject(map).toString();
    }


}
