package com.blog.controller;

import com.blog.entity.Article;
import com.blog.entity.User;
import com.blog.service.IArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shanhe
 * @className UserController
 * @date 2020-03-30 00:46
 **/
@Controller
public class UserController {

    @Autowired
    private IArticleService articleService;

    @RequestMapping("/user/{id}")
    public String userDetail(@PathVariable("id") int id, Model model) {
        /**
         * TODO
         * model.addAttribute("user", userService(id));
         */
        //System.out.println(id);
        if(id == -1) {
            return "login";
        }
        return "user";
    }

    @RequestMapping("/user/articles")
    public String myArticles(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                             HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        PageInfo<Article> pageInfo = null;
        if(user != null) {
            pageInfo = articleService.findByUserId(user.getUserId(), pageNum, pageSize);
        }
        model.addAttribute("pageInfo", pageInfo);
        return "myArticles";
    }

    @RequestMapping("/attention")
    public String attention() {
        return "attention";
    }

    @RequestMapping("/fans")
    public String fans() {
        return "fans";
    }

    @RequestMapping("/user/collection")
    public String collection() {
        return "collection";
    }
}
