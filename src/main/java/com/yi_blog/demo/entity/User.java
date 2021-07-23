package com.yi_blog.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String blog_title;
    private Date create_time;
    private String email;
}
