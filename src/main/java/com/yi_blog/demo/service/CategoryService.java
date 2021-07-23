package com.yi_blog.demo.service;

import com.github.pagehelper.PageInfo;
import com.yi_blog.demo.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> queryAll();
    void addCategory(Category category);
    void delCategoryById(int id);
    PageInfo queryByPage(int pageNum, int pageSize);
    Category queryById(int category_id);
}
