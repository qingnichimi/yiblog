package com.yi_blog.demo.mapper;

import com.yi_blog.demo.entity.Category;
import com.yi_blog.demo.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> queryAll();
    void addCategory(Category category);
    void delCategoryById(int id);
    Category queryById(int category_id);
}
