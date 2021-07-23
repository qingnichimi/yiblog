package com.yi_blog.demo.controller;

import com.yi_blog.demo.entity.Article;
import com.yi_blog.demo.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ArchiveController {
    @Resource
    ArticleService articleService;
    @RequestMapping("/archive")
    public String archive(Model model){
        List<Article> articles = articleService.queryArticleAll();
        model.addAttribute("articles",articles);
        List<String> timeList = articleService.queryTimeGroup();
        model.addAttribute("timeList",timeList);
        return "archive";
    }
}
