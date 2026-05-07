package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.StudentJobOption;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    //员工职位分布数据
    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        List jobList = list.stream().map(m->m.get("pos")).toList();
        List dataList = list.stream().map(m->m.get("num")).toList();
        return new JobOption(jobList,dataList);
    }

    //员工性别分布数据

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    //学员学历

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return empMapper.countStudentDegreeData();
    }

    //班级人数

    @Override
    public StudentJobOption getStudentCountData() {
        List<Map<String, Object>> list = empMapper.countStudentCountData();
        List jobList=list.stream().map(m->m.get("pos")).toList();
        List dataList=list.stream().map(m->m.get("num")).toList();
        return new StudentJobOption(jobList,dataList);
    }
}
