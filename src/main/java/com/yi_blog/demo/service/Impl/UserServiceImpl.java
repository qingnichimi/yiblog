package com.yi_blog.demo.service.Impl;

import com.yi_blog.demo.entity.User;
import com.yi_blog.demo.mapper.UserMapper;
import com.yi_blog.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delUser(int id) {
        userMapper.delUser(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        List<User>userList = userMapper.queryAllUser();
        return userList;
    }

    @Override
    public User queryUser(String username,String password) {
        User user = userMapper.queryUser(username,password);
        return user;
    }
}
