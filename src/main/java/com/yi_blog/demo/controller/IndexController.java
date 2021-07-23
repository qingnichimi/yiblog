package com.yi_blog.demo.controller;

import com.github.pagehelper.PageInfo;
import com.yi_blog.demo.entity.Article;
import com.yi_blog.demo.entity.User;
import com.yi_blog.demo.service.ArticleService;
import com.yi_blog.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Resource
    private ArticleService articleService;
    @Resource
    private UserService userService;
    @RequestMapping({"/","/index"})
    public String index(Model model,
                        @RequestParam(value = "pageNum",defaultValue="1")int pageNum,
                        HttpSession session){
        if(userService.queryAllUser().size() == 0){
            return "register";
        }
        List<Article> articles = articleService.queryArticleAll();
        PageInfo pageInfo = articleService.queryByPage(pageNum,9);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("articles",articles);
        return "index";
    }
}
