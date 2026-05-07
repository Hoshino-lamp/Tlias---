package com.itheima.service;

import com.itheima.pojo.Log;

import java.util.List;

public interface LogService {
    List<Log> list(Integer page, Integer pageSize);
}
