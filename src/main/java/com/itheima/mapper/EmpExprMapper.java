package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void insertBatch(List<EmpExpr> exprList);

    void delete(List<Integer> empIds);

    @Select("select * from emp_expr where emp_id=#{empId}")
    List<EmpExpr> getByEmpId(Integer empId);
}
