package com.yi_blog.demo.mapper;

import com.yi_blog.demo.entity.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {
    void addLog(Log log);
    List<Log> queryAllLog();
}
