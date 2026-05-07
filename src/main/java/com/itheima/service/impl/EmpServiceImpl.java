package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.*;
import com.itheima.service.EmpLogService;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;
//    @Override
//    public PageResult<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
//        //原始查询
////        long total = empMapper.count();
////        Integer start = (page-1)*pageSize;
////        List<Emp> list = empMapper.list(start,pageSize);
//
//
//        PageHelper.startPage(page,pageSize);
//        List<Emp> list = empMapper.list(name,gender,begin,end);
//        Page<Emp> p=(Page<Emp>) list;
//        return new PageResult<>(p.getTotal(),p.getResult());
//    }

    //员工查询
    @Override
    public PageResult<Emp> list(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> list = empMapper.list(empQueryParam);
        Page<Emp> p=(Page<Emp>) list;
        return new PageResult<>(p.getTotal(),p.getResult());
    }

    //所有员工查询
    @Override
    public List<Emp> listAll() {
        return empMapper.listAll();
    }

    //新增员工
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        try {
            emp.setUpdateTime(LocalDateTime.now());
            emp.setCreateTime(LocalDateTime.now());
            empMapper.insert(emp);

            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            //添加员工日志
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"添加员工"+emp);
            empLogService.insertLog(empLog);
        }


    }

    //员工删除
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {


            //emp 删除
            empMapper.delete(ids);

            //empExpr 删除
            empExprMapper.delete(ids);

    }

    //id查询
    @Override
    public Emp getById(Integer id) {
        //查询员工数据
        Emp emp = empMapper.getById(id);

        //查询员工工作经历
        emp.setExprList(empExprMapper.getByEmpId(id));
        return emp;
    }

    //员工修改
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        //修改员工数据
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        //删除员工工作经历
        empExprMapper.delete(Arrays.asList(emp.getId()));
        //添加员工工作经历
        List<EmpExpr> exprList=emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }

    }
}
