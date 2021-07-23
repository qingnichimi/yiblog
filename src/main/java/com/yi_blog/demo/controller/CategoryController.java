package com.yi_blog.demo.controller;

import com.github.pagehelper.PageInfo;
import com.yi_blog.demo.entity.Article;
import com.yi_blog.demo.entity.Category;
import com.yi_blog.demo.entity.Log;
import com.yi_blog.demo.service.ArticleService;
import com.yi_blog.demo.service.CategoryService;
import com.yi_blog.demo.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class CategoryController {
    @Resource
    private ArticleService articleService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private LogService logService;
    @RequestMapping("/category")
    public String category(Model model){
        List<Article> articles = articleService.queryArticleOrderByCategory();
        List<Category> categories = categoryService.queryAll();
        model.addAttribute("categories",categories);
        model.addAttribute("articles",articles);
        System.out.println(articles.size());
        return "category";
    }
    @GetMapping("/admin/category")
    public String show(Model model,
                       @RequestParam(value = "pageNum",defaultValue = "1")int pageNum){
        List<Category> categories = categoryService.queryAll();
        PageInfo pageInfo = categoryService.queryByPage(pageNum,9);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("categories",categories);
        return "category_setting";
    }
    @GetMapping("/admin/addCategory")
    public String addCategory(@RequestParam("name")String name,
                              Model model){
        Category category = new Category();
        category.setName(name);
        categoryService.addCategory(category);
        Log log = new Log();
        log.setAction("添加分类:"+category.getName());
        log.setTime(new Date());
        logService.addLog(log);
        return "redirect:/admin/category";
    }
    @GetMapping("/admin/delCategory")
    public String delCategory(@RequestParam("category_id")int category_id){
        Category category = categoryService.queryById(category_id);
        Log log = new Log();
        log.setAction("删除分类:"+category.getName());
        log.setTime(new Date());
        logService.addLog(log);
        if(category !=null){
            categoryService.delCategoryById(category_id);
        }
        return "redirect:/admin/category";
    }
}
