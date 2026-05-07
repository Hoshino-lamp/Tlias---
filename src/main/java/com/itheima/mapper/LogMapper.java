package com.itheima.mapper;

import com.itheima.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    //未完成
    @Select("select * from emp_log")
    List<Log> list();
}
