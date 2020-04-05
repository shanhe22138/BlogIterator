package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shanhe
 * @className UserController
 * @date 2020-03-30 00:46
 **/
@Controller
public class UserController {

    @RequestMapping("/user/{id}")
    public String userDetail(@PathVariable("id") int id, Model model) {
        /**
         * TODO
         * model.addAttribute("user", userService(id));
         */
        System.out.println(id);
        if(id == -1) {
            return "login";
        }
        return "user";
    }
}
