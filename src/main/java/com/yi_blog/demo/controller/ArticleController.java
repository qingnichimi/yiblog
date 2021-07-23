package com.yi_blog.demo.controller;

import com.github.pagehelper.PageInfo;
import com.yi_blog.demo.entity.Article;
import com.yi_blog.demo.entity.Category;
import com.yi_blog.demo.entity.Comment;
import com.yi_blog.demo.entity.Log;
import com.yi_blog.demo.service.ArticleService;
import com.yi_blog.demo.service.CategoryService;
import com.yi_blog.demo.service.CommentService;
import com.yi_blog.demo.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class    ArticleController {
    @Resource
    ArticleService articleService;
    @Resource
    CommentService commentService;
    @Resource
    LogService logService;
    @Resource
    CategoryService categoryService;
    @RequestMapping("/write_save")
    public String save(@RequestParam("title")String title,
                       @RequestParam("content-md")String content_md,
                       @RequestParam("category")int category,
                       @RequestParam("content-html-code")String content_html,
                       Model model){
        Article article = new Article();
        article.setContent_md(content_md);
        article.setTitle(title);
        article.setContent(content_html);
        article.setUpdatetime(new Date());
        article.setCategory(category);
        System.out.println(category);
        articleService.save(article);
        Log log =new Log();
        log.setAction("发布文章:"+article.getTitle());
        log.setTime(new Date());
        logService.addLog(log);
        return "redirect:/admin";
    }
    @GetMapping("/article")
    public String show(@RequestParam("id") int id,
                       Model model){
        articleService.hits(id);
        Article article = articleService.queryById(id);
        List<Comment> comments = commentService.queryCommentByArticleId(id);
        model.addAttribute("comments",comments);
        model.addAttribute("article",article);
        return "article";
    }
    @GetMapping("/admin/article")
    public String show(Model model,
                       @RequestParam(value = "pageNum",defaultValue="1")int pageNum){
        List<Article> articles = articleService.queryArticleAll();
        PageInfo pageInfo = articleService.queryByPage(pageNum,9);
        model.addAttribute("articles",articles);
        model.addAttribute("pageInfo",pageInfo);
        return "article_setting";
    }
    @GetMapping("/admin/edit")
    public String edit(@RequestParam("id")int id,
                       Model model,
                       HttpSession session){
        Article article = articleService.queryById(id);
        session.setAttribute("article_edit",article);
        model.addAttribute("article_edit",article);
        List<Category> categories = categoryService.queryAll();
        model.addAttribute("categories",categories);
        Log log =new Log();
        log.setAction("编辑文章:"+article.getTitle()+"-未保存");
        log.setTime(new Date());
        logService.addLog(log);
        return "redirect:/article_edit";
    }
    @GetMapping("/admin/edit_save")
    public String edit_save(@RequestParam("title")String title,
                            @RequestParam("id")int id,
                            @RequestParam("content-md")String content_md,
                            @RequestParam("content-html-code")String content_html){
        Article article = new Article();
        article.setId(id);
        System.out.println(id);
        article.setTitle(title);
        article.setContent_md(content_md);
        article.setContent(content_html);
        articleService.edit_save(article);
        Log log =new Log();
        log.setAction("保存修改文章:"+article.getTitle());
        log.setTime(new Date());
        logService.addLog(log);
        return "redirect:/admin/article";
    }
    @GetMapping("/admin/delArticle")
    public String delArticle(@RequestParam("id")int id){
        Article article = articleService.queryById(id);
        Log log =new Log();
        log.setAction("删除文章:"+article.getTitle());
        log.setTime(new Date());
        logService.addLog(log);

        if(article != null){
            articleService.delArticle(id);
        }
        return "redirect:/admin/article";
    }
    @GetMapping("/search")
    public String queryLike(@RequestParam("keyWord")String keyWord,
                            @RequestParam(value = "pageNum",defaultValue="1")int pageNum,
                            Model model){
        List<Article> articles = articleService.queryLike("%"+keyWord+"%");
        PageInfo pageInfo = articleService.queryByPage(pageNum,9);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("articles",articles);
        return "index";
    }


}
