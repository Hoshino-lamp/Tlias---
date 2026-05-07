package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/depts")
@RestController
@Slf4j
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result list(){
        log.info("查询所有部门数据");
        List<Dept> deptlist = deptService.findAll();
        return Result.success(deptlist);
    }

    @DeleteMapping
    public Result delete(Integer id){
        log.info("删除部门数据:{}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加部门数据:{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询部门数据:{}",id);
        return Result.success(deptService.getById(id));
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门数据:{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
