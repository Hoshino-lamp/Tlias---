package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzIdQueryParam;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClazzSerivceImpl implements ClazzService {
    @Autowired
    ClazzMapper clazzMapper;
    @Override
    public PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        List<Clazz> list =clazzMapper.list(clazzQueryParam);
        Page<Clazz> p=(Page<Clazz>) list;

        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Override
    public List<Clazz> listAll() {
        return clazzMapper.listAll();
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        LocalDate now = LocalDate.now();
        LocalDate BeginDate = LocalDate.parse(clazz.getBeginDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate EndDate = LocalDate.parse(clazz.getEndDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (now.isBefore(EndDate)&& now.isAfter(BeginDate)){
            clazz.setStatus("已开班");
        }else if(now.isAfter(EndDate)){
            clazz.setStatus("已结课");
        }else if(now.isBefore(BeginDate)){
            clazz.setStatus("未开班");
        }
        clazzMapper.save(clazz);
    }

    @Override
    public ClazzIdQueryParam getById(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }
}
