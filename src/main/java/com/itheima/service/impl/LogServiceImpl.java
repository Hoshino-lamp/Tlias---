package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.mapper.LogMapper;
import com.itheima.pojo.Log;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public List<Log> list(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        return logMapper.list();

    }
}
