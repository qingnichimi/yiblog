package com.yi_blog.demo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yi_blog.demo.entity.Article;
import com.yi_blog.demo.entity.Comment;
import com.yi_blog.demo.mapper.CommentMapper;
import com.yi_blog.demo.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper commentMapper;
    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    @Override
    public List<Comment> queryCommentByArticleId(int article_id) {
        return commentMapper.queryCommentByArticleId(article_id);
    }

    @Override
    public int count() {
        return commentMapper.count();
    }

    @Override
    public void delComment(int comment_id) {
        commentMapper.delComment(comment_id);
    }

    @Override
    public PageInfo queryByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> commentList = commentMapper.queryAllComment();
        PageInfo pageInfo = new PageInfo(commentList);
        return pageInfo;
    }

    @Override
    public Comment queryById(int comment_id) {
        return commentMapper.queryById(comment_id);
    }

    @Override
    public void delByArticleId(int id) {
        commentMapper.delByArticleId(id);
    }

    @Override
    public List<Comment> queryAllComment() {
        return commentMapper.queryAllComment();
    }

}
