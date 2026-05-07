package com.itheima.service;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzIdQueryParam;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    //分页查询班级数据
    PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    void save(Clazz clazz);

    List<Clazz> listAll();

    ClazzIdQueryParam getById(Integer id);

    void update(Clazz clazz);
}
