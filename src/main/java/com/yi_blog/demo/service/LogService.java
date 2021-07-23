package com.yi_blog.demo.service;

import com.yi_blog.demo.entity.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogService {
    void addLog(Log log);
    List<Log> queryAllLog();
}
