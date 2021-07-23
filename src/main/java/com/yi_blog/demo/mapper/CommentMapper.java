package com.yi_blog.demo.mapper;

import com.yi_blog.demo.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void addComment(Comment comment);
    List<Comment> queryAllComment();
    List<Comment> queryCommentByArticleId(int article_id);
    int count();
    void delComment(int comment_id);
    Comment queryById(int comment_id);
    void delByArticleId(int id);
}
