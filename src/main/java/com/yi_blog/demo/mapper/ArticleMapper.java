package com.yi_blog.demo.mapper;

import com.yi_blog.demo.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {
    List<Article>queryArticleAll();
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
    List<Article> queryLike(String keyWord);
    List<String> queryTimeGroup();
}
