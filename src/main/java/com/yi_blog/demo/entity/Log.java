package com.yi_blog.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Log {
    private int log_id;
    private String action;
    private Date time;
}
