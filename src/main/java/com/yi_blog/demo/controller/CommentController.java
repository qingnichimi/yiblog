package com.yi_blog.demo.controller;

import com.github.pagehelper.PageInfo;
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
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {
    @Resource
    ArticleService articleService;
    @Resource
    CommentService commentService;
    @Resource
    LogService logService;
    @Resource
    CategoryService categoryService;
    @RequestMapping("/comment")
    public String comment(@RequestParam("nikename")String nickname,
                          @RequestParam("email")String email,
                          @RequestParam("comment")String comment,
                          @RequestParam("article_id")int article_id,
                          @RequestParam("link")String link,
                          Model model){
        Comment comments = new Comment();
        comments.setNickname(nickname);
        comments.setEmail(email);
        comments.setArticle_id(article_id);
        comments.setLink(link);
        comments.setComment(comment);
        comments.setTime(new Date());
        commentService.addComment(comments);
        model.addAttribute("article_id",article_id);

        return "redirect:/article?id="+article_id;
    }
    @GetMapping("/admin/comment")
    public String comment(Model model,
                          @RequestParam(value = "pageNum",defaultValue="1")int pageNum){
        List<Comment> comments = commentService.queryAllComment();
        PageInfo pageInfo = commentService.queryByPage(pageNum,9);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("comments",comments);
        return "comment_setting";
    }
    @GetMapping("/admin/delComment")
    public String delComment(@RequestParam("comment_id")int comment_id){
        Comment comment = commentService.queryById(comment_id);
        Log log =new Log();
        log.setAction("删除评论:"+comment.getComment());
        log.setTime(new Date());
        logService.addLog(log);
        if(comment !=null){
            commentService.delComment(comment_id);
        }
        return "redirect:/admin/comment";
    }
}
