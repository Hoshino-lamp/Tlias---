package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentIdQueryParam;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    //条件分页查询
    @Override
    public PageResult<Student> list(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());

        Page<Student> p=(Page<Student>) studentMapper.list(studentQueryParam);

        return new PageResult<>(p.getTotal(),p.getResult());
    }

    //批量删除
    @Override
    public void deleteById(List<Integer> ids) {
        studentMapper.deleteById(ids);
    }

    //添加
    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.save(student);
    }
    //id查询
    @Override
    public StudentIdQueryParam findById(Integer id) {

        return studentMapper.findById(id);
    }

    //修改
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    //违纪处理

    @Override
    public void handle(Integer id, Integer score) {
        LocalDateTime now = LocalDateTime.now();
        studentMapper.handle(id,score,now);
    }
}
