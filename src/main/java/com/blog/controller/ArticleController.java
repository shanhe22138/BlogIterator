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

    private Article findArticleById(int id) {
        if(id < 1) {
            return null;
        }
        return articleService.findById(id);
    }

    private void addArticleDetail(Model model, Article article, List<Comment> comments) {
        model.addAttribute("article", article);
        model.addAttribute("comments", comments);
    }

    @RequestMapping(value = "/article")
    public String article() {
        return "article";
    }

    @RequestMapping(value = "/article/insert", method = RequestMethod.POST)
    public String saveArticle(HttpSession session, ArticleParam articleParam) {
        User user = (User) session.getAttribute("user");

        //System.out.println(articleParam);
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
            summary = summaryText.substring(0, Constant.SUMMARY_MAX_LENGTH);
        }
        article.setArticleSummary(summary);

        /**
         * TODO
         * 标签插入
         */
        articleService.save(article);

        return "redirect:/home";

    }

    @RequestMapping(value = "/article/{id}")
    public String showArticle(@PathVariable("id") Integer id, Model model) {
        /**
         * TODO
         * voewCount+1
         */
        articleService.addViewCount(id);
        Article article = findArticleById(id);
        List<Comment> comments = commentService.findByArticleId(id);
        //System.out.println(comments);
        addArticleDetail(model, article, comments);

        return "showArticle";
    }

    @RequestMapping("/article/comment/viewReplay/{articleId}/{commentPid}")
    public String viewReplay(@PathVariable("articleId") Integer articleId,
                                @PathVariable("commentPid") Integer commentPid, Model model) {
        Article article = findArticleById(articleId);
        //System.out.println(commentPid);
        List<Comment> comments = commentService.findReplay(commentPid);
        addArticleDetail(model, article, comments);

        return "showArticle";
    }
}
