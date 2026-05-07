package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    //员工查询
    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("参数：{}",empQueryParam);
        PageResult<Emp> pageResult = empService.list(empQueryParam);
        return Result.success(pageResult);
    }

    //所有员工查询
    @GetMapping("/list")
    public Result listAll(){
        log.info("查询所有员工数据");
        return Result.success(empService.listAll());
    }

    //新增员工
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工，参数：{}",emp);
        empService.save(emp);
        return Result.success();
    }

    //员工删除
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("员工删除，参数：{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    //id查询
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询员工数据:{}",id);
        return Result.success(empService.getById(id));
    }

    //修改员工
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工数据:{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
