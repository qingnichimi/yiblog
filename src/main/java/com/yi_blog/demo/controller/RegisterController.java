package com.yi_blog.demo.controller;

import com.yi_blog.demo.entity.User;
import com.yi_blog.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

import java.util.Date;

@Controller
public class RegisterController {
    @Resource
    private UserService userService;
    @RequestMapping("/register")
    public String registers(@RequestParam("username")String username,
                           @RequestParam("password")String password,
                           @RequestParam("email")String email,
                            @RequestParam("blog_title")String blog_title,
                           Model model){
        if(username != null && !username.equals("") && password != null && !password.equals("") && email != null && !email.equals("") && blog_title != null && !blog_title.equals("")){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setBlog_title(blog_title);
            Date now = new Date();
            user.setCreate_time(now);
            userService.addUser(user);
            System.out.println("add success");
            return "login";
        }else{
            model.addAttribute("msg","不能为空");
            return "register";
        }
    }
}
