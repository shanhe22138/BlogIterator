package com.blog.controller;

import com.blog.entity.User;
import com.blog.service.IUserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shanhe
 * @className AdminController
 * @date 2020-03-09 11:27
 **/
@Controller
public class AdminController {
    @Autowired
    IUserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginVerify", method = RequestMethod.POST)
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
//        if(session.getAttribute("user") != null) {
//            return "redirect:home";
//        }
        String name = request.getParameter("user");
        String password = request.getParameter("password");
        String flag = request.getParameter("rememberMe");

        User user = userService.findByPhoneNumOrEmail(name);

        Map<String, Object> map = new HashMap<>();

        if (user == null) {
            map.put("code", 0);
            map.put("msg", "用户名或email未注册");
        } else if(password.equals(user.getUserPassword())) {

            map.put("code", 1);
            map.put("msg", "登陆成功！");
            /**
             * TODO
             * 用户登陆时间更新，session在更新后再添加用户数据
             */
            session.setAttribute("user", user);
            if("1".equals(flag)) {
                Cookie cookie = new Cookie("name", name);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);
                cookie = new Cookie("password", password);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);

            }
        } else {
            map.put("code", 2);
            map.put("msg", "密码错误");
        }

        String result = new JSONObject(map).toString();
        return result;

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/home";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "registerVerify", method = RequestMethod.POST)
    @ResponseBody
    public String registerVerify(HttpServletRequest request) {
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");

        User user = new User();
        if(uname.matches("\\d+")) {
            user.setUserPhoneNumber(uname);
        } else {
            user.setUserEmail(uname);
        }
        if(nickname != null) {
            user.setUserNickname(nickname);
        }
        user.setUserPassword(password);
        user.setUserRegisterTime(new Date());

        int flag = userService.addUser(user);
        Map<String, Object> map = new HashMap<>();
        map.put("code", flag);
        if(flag == 0) {
            map.put("msg", "用户名或邮箱已注册！");
        } else {
            map.put("msg", "注册成功！");
            user.setUserLastLoginTime(new Date());
            /**
             * TODO
             * update
             */
            request.getSession().setAttribute("user", user);
        }
        String result = new JSONObject(map).toString();
        return result;
    }

//    @RequestMapping("/example")
//    public String example(){
//        return "../../home";
//    }
}
