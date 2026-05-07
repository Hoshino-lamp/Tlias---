package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentIdQueryParam;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> list(StudentQueryParam studentQueryParam);

    void deleteById(List<Integer> ids);

    void save(Student student);

    StudentIdQueryParam findById(Integer id);

    void update(Student student);

    void handle(Integer id, Integer score);
}
