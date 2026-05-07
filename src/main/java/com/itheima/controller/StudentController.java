package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentIdQueryParam;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;
    //条件分页查询
    @GetMapping
    public Result list(StudentQueryParam studentQueryParam){
        log.info("条件查询{}",studentQueryParam);
        return Result.success(studentService.list(studentQueryParam));
    }

    //批量删除学员
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除{}",ids);
        studentService.deleteById(ids);
        return Result.success();
    }

    //添加学员
    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("添加学员数据{}",student);
        studentService.save(student);
        return Result.success();
    }

    //id查询
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("id查询{}",id);
        return Result.success(studentService.findById(id));
    }

    //修改
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学员数据:{}",student);
        studentService.update(student);
        return Result.success();
    }

    //违纪处理
    @PutMapping("/violation/{id}/{score}")
    public Result handle(@PathVariable Integer id,@PathVariable Integer score){
        log.info("id:{},score:{}",id,score);
        studentService.handle(id,score);
        return Result.success();
    }
}
