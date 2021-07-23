package com.yi_blog.demo.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Article {
    private int id;
    private String content;
    private String content_md;
    private String title;
    private int comment;
    private Date updatetime;
    private int category;
    private int hits;
}
