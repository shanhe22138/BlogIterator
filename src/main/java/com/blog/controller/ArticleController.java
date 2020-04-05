package com.blog.controller;

import cn.hutool.http.HtmlUtil;
import com.blog.dto.ArticleParam;
import com.blog.entity.Article;
import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.service.IArticleService;
import com.blog.service.ICommentService;
import com.blog.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author shanhe
 * @className ArticleController
 * @date 2020-03-11 20:30
 **/
@Controller
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ICommentService commentService;

    @RequestMapping(value = "/article")
    public String article() {
        return "article";
    }

    @RequestMapping(value = "/article/insert", method = RequestMethod.POST)
    public String saveArticle(HttpSession session, ArticleParam articleParam) {
        User user = (User) session.getAttribute("user");

        System.out.println(articleParam);
        Article article = new Article();
        if(user != null) {
            article.setUserId(user.getUserId());
        }
        article.setArticleTitle(articleParam.getArticleTitle());
        article.setArticleContent(articleParam.getArticleContent());
        article.setArticleCreateTime(new Date());

        String summaryText = HtmlUtil.cleanHtmlTag(article.getArticleContent());
        String summary;
        if(summaryText.length() < Constant.SUMMARY_MAX_LENGTH) {
            summary = summaryText;
        } else {
            summary = summaryText.substring(0,150);
        }
        article.setArticleSummary(summary);

        /**
         * TODO
         * 标签插入
         */
        articleService.save(article);

        return "home";

    }

    @RequestMapping(value = "/article/{id}")
    public String showArticle(@PathVariable("id") Integer id, Model model) {
        /**
         * TODO
         * voewCount+1
         */
        articleService.addViewCount(id);
        Article article = articleService.findById(id);
        List<Comment> comments = commentService.findByArticleId(id);
        System.out.println(comments);
        model.addAttribute("article", article);
        model.addAttribute("comments", comments);
        return "showArticle";
    }
}
