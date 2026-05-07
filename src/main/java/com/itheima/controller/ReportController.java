package com.itheima.controller;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.pojo.StudentJobOption;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//报表管理
@RestController
@RequestMapping("/report")
@Slf4j
public class ReportController {

    @Autowired
    private ReportService reportService;

    //员工职位分布数据
    @GetMapping("/empJobData")
    public Result export(){
        log.info("导出报表");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    //统计员工性别分布数据
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别分布数据");
        List<Map<String, Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    //统计学员学历分布数据
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学员学历分布数据");
        List<Map<String, Object>> degreeList = reportService.getStudentDegreeData();
        return Result.success(degreeList);
    }

    //统计班级人数分布数据
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("统计班级人数分布数据");
        StudentJobOption jobOption = reportService.getStudentCountData();
        return Result.success(jobOption);
    }

}
