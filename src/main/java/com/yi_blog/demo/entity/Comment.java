package com.yi_blog.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private int comment_id;
    private String email;
    private String nickname;
    private String link;
    private int article_id;
    private String comment;
    private Date time;

}
