package com.yi_blog.demo.controller;

import com.github.pagehelper.PageInfo;
import com.yi_blog.demo.entity.Article;
import com.yi_blog.demo.entity.Category;
import com.yi_blog.demo.entity.Comment;
import com.yi_blog.demo.entity.Log;
import com.yi_blog.demo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Resource
    ArticleService articleService;
    @Resource
    CommentService commentService;
    @Resource
    LogService logService;
    @Resource
    private UserService userService;
    @GetMapping("/admin")
    public String overview(Model model){
        if(userService.queryAllUser().size() == 0){
            return "register";
        }
        int article_count = articleService.count();
        int comment_count = commentService.count();
        int totalHits = articleService.totalHits();
        List<Log>logs = logService.queryAllLog();
        model.addAttribute("article_count",article_count);
        model.addAttribute("comment_count",comment_count);
        model.addAttribute("article_hits",totalHits);
        model.addAttribute("logs",logs);
        return "admin_index";
    }


}
