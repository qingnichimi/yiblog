package com.yi_blog.demo.service;

import com.yi_blog.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /*
    增删改查
    */
    void addUser(User user);
    void delUser(int id);
    void updateUser(User user);
    List<User>queryAllUser();
    User queryUser(String username,String password);
}
