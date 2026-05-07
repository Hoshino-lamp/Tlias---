package com.itheima.mapper;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentIdQueryParam;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface StudentMapper {
    //条件查询学员
    List<Student> list(StudentQueryParam studentQueryParam);

    //批量删除学员
    void deleteById(List<Integer> ids);

    //添加学员
    @Insert("insert into student(name,no,gender,phone,degree,id_card,is_college,address,graduation_date,violation_count,violation_score,clazz_id,create_time,update_time) " +
    "values(#{name},#{no},#{gender},#{phone},#{degree},#{idCard},#{isCollege},#{address},#{graduationDate},#{violationCount},#{violationScore},#{clazzId},#{createTime},#{updateTime})")
    void save(Student student);

    //id查询
    @Select("select * from student where id=#{id}")
    StudentIdQueryParam findById(Integer id);

    //修改学员
    void update(Student student);

    //违纪处理
    @Select("update student set violation_count=violation_count+1,violation_score=violation_score+#{score},update_time=#{now} where id=#{id}")
    void handle(Integer id, Integer score, LocalDateTime now);
}
