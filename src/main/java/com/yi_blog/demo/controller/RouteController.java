package com.yi_blog.demo.controller;

import com.yi_blog.demo.entity.Category;
import com.yi_blog.demo.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RouteController {
    @Resource
    private CategoryService categoryService;
    public String index(){
        return "index";
    }

    @GetMapping("/register")
    public  String register(){
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/write")
    public String write(Model model){
       List<Category> categories =  categoryService.queryAll();
       model.addAttribute("categories",categories);
        return "article_write";
    }

    @GetMapping("/article_edit")
    public String edit(){
        return "article_edit";
    }




}
