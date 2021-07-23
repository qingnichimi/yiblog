package com.yi_blog.demo.controller;

import com.yi_blog.demo.entity.Log;
import com.yi_blog.demo.entity.User;
import com.yi_blog.demo.service.LogService;
import com.yi_blog.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class LoginController {
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
            User user = userService.queryUser(username, password);
            Log log = new Log();
            log.setAction("登录后台");
            log.setTime(new Date());
            logService.addLog(log);
            if (user != null) {
                session.setAttribute("username",user.getUsername());
                return "redirect:/admin";
            } else {
                model.addAttribute("msg", "用户名或密码错误");
                return "login";
            }

        }
    }
