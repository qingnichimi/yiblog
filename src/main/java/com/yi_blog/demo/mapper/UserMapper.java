package com.yi_blog.demo.mapper;

import com.yi_blog.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void addUser(User user);
    void delUser(int id);
    void updateUser(User user);
    List<User> queryAllUser();
    User queryUser(String username,String password);
}
