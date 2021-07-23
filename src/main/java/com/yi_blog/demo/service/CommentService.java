package com.yi_blog.demo.service;

import com.github.pagehelper.PageInfo;
import com.yi_blog.demo.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    void addComment(Comment comment);
    List<Comment> queryAllComment();
    List<Comment> queryCommentByArticleId(int article_id);
    int count();
    void delComment(int comment_id);
    PageInfo queryByPage(int pageNum, int pageSize);
    Comment queryById(int comment_id);
    void delByArticleId(int id);
}
