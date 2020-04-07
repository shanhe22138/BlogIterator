package com.blog.controller;

import com.blog.entity.Article;
import com.blog.entity.User;
import com.blog.service.IArticleService;
import com.blog.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author shanhe
 * @className HomeController
 * @date 2020-03-16 15:32
 **/
@Controller
public class HomeController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IArticleService articleService;

    @RequestMapping(value = {"/", "/home"})
    public String home(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                       @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                       HttpSession session, Model model)/* throws ExecutionException, InterruptedException*/ {
        /**
         * TODO
         * 用户新消息提醒
         * DB中新建一个表，存储新信息
         */
        User user = (User)session.getAttribute("user");
        if(user != null) {
            user.setUserLastLoginTime(new Date());
            userService.update(user);
        }


        //获取文章列表
        PageInfo<Article> pageInfo = articleService.findByPage(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "home";
    }
}


