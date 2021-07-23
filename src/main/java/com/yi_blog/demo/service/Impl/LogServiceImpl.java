package com.yi_blog.demo.service.Impl;

import com.yi_blog.demo.entity.Log;
import com.yi_blog.demo.mapper.LogMapper;
import com.yi_blog.demo.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Resource
    LogMapper logMapper;
    @Override
    public void addLog(Log log) {
        logMapper.addLog(log);
    }

    @Override
    public List<Log> queryAllLog() {
        return logMapper.queryAllLog();
    }
}
