package com.yi_blog.demo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yi_blog.demo.entity.Category;
import com.yi_blog.demo.mapper.CategoryMapper;
import com.yi_blog.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> queryAll() {
        return categoryMapper.queryAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public void delCategoryById(int id) {
        categoryMapper.delCategoryById(id);
    }

    @Override
    public PageInfo queryByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Category> categoryList = categoryMapper.queryAll();
        PageInfo pageInfo = new PageInfo(categoryList);
        return pageInfo;
    }

    @Override
    public Category queryById(int category_id) {
        return categoryMapper.queryById(category_id);
    }

}
