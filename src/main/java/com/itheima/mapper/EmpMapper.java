package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface EmpMapper {
//    //查询员工总记录数
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id;")
//    public long count();
//
//    //分页查询员工数据
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time desc limit #{start},#{pageSize};")
//    public List<Emp> list(Integer start, Integer pageSize);

    //PageHelper分页插件
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time desc")
//    public List<Emp> list();

    //查询员工
    List<Emp> list(EmpQueryParam empQueryParam);

    //新增员工
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(id, username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{id},#{username},#{password},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    //批量删除员工
    void delete(List<Integer> ids);

    //id查询
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    void updateById(Emp emp);

    @Select("select * from emp")
    List<Emp> listAll();

    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();

    @MapKey("name")
    List<Map<String, Object>> countStudentDegreeData();

    @MapKey("pos")
    List<Map<String, Object>> countStudentCountData();
}
