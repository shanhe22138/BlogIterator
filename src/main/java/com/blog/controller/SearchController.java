package com.blog.controller;

import com.blog.entity.Article;
import com.blog.service.IArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shanhe
 * @className SearchController
 * @date 2020-04-08 19:26
 **/
@Controller
public class SearchController {

    @Autowired
    private IArticleService articleService;

    @RequestMapping(value = "/top-search", method = RequestMethod.POST)
    public String top_search(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(required=false, defaultValue = "6") Integer pageSize,
                             HttpServletRequest request, Model model) {
        System.out.print("数据到达后端：");
        String query = request.getParameter("top_search");
        System.out.println(query);
        PageInfo<Article> pageInfo = articleService.findPageByQuery(query, pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        System.out.println("从数据看获取数据：" + pageInfo.getList());

        return "topSearch";
    }


}
