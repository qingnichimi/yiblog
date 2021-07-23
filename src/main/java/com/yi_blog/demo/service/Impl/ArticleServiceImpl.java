package com.yi_blog.demo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yi_blog.demo.entity.Article;
import com.yi_blog.demo.mapper.ArticleMapper;
import com.yi_blog.demo.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> queryArticleAll() {
        return articleMapper.queryArticleAll();
    }

    @Override
    public List<Article> queryArticleOrderByCategory() {
        return articleMapper.queryArticleOrderByCategory();
    }

    @Override
    public void save(Article article) {
        articleMapper.save(article);
    }

    @Override
    public Article queryById(int id) {
        return articleMapper.queryById(id);
    }

    @Override
    public void edit_save(Article article) {
         articleMapper.edit_save(article);
    }

    @Override
    public void delArticle(int id) {
        articleMapper.delArticle(id);
    }

    @Override
    public void delArticleByCategoryId(int category_id) {
        articleMapper.delArticleByCategoryId(category_id);
    }

    @Override
    public Article queryByCategoryId(int category_id) {
        return articleMapper.queryByCategoryId(category_id);
    }

    @Override
    public int count() {
        return articleMapper.count();
    }



    @Override
    public void hits(int id) {
        articleMapper.hits(id);
    }

    @Override
    public int totalHits() {
       return articleMapper.totalHits();
    }

    @Override
    public PageInfo queryByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articleList = articleMapper.queryArticleAll();
        PageInfo pageInfo = new PageInfo(articleList);
        return pageInfo;
    }

    @Override
    public List<Article> queryLike(String keyWord) {
       return articleMapper.queryLike(keyWord);
    }

    @Override
    public PageInfo queryByPageLike(int pageNum, int pageSize,String keyWord) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articleList = articleMapper.queryLike(keyWord);
        PageInfo pageInfo = new PageInfo(articleList);
        return pageInfo;
    }

    @Override
    public List<String> queryTimeGroup() {
        return articleMapper.queryTimeGroup();
    }
}
