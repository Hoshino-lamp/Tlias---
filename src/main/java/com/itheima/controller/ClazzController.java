package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clazzs")
@RestController
@Slf4j
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    //班级查询
    @GetMapping
    public Result list(ClazzQueryParam clazzQueryParam){
        log.info("条件查询班级数据{}",clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.findAll(clazzQueryParam);
        return Result.success(pageResult);
    }
    
    //查询所有班级
    @GetMapping("/list")
    public Result listAll(){
        log.info("查询所有班级数据");

        return Result.success(clazzService.listAll());
    }

    //删除班级
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级数据{}",id);
        clazzService.deleteById(id);
        return Result.success();
    }

    //添加班级
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加班级数据{}",clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    //id查询
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询班级数据:{}",id);
        return Result.success(clazzService.getById(id));
    }

    //修改班级
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级数据:{}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }
}
