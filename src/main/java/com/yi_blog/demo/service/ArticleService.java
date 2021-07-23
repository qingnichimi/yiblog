package com.yi_blog.demo.service;

import com.github.pagehelper.PageInfo;
import com.yi_blog.demo.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    List<Article> queryArticleAll();
    List<Article>queryArticleOrderByCategory();
    void save(Article article);
    Article queryById(int id);
    void edit_save(Article article);
    void delArticle(int id);
    void delArticleByCategoryId(int category_id);
    Article queryByCategoryId(int category_id);
    int count();
    void hits(int id);
    int totalHits();
    PageInfo queryByPage(int pageNum,int pageSize);
    List<Article> queryLike(String keyWord);
    PageInfo queryByPageLike(int pageNum,int pageSize,String keyWord);
    List<String> queryTimeGroup();
}
