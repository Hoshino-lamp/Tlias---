package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzIdQueryParam;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {
    //条件分页查询
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    //查询所有班级
    @Select("select * from class")
    List<Clazz> listAll();

    //删除班级
    @Delete("delete from class where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into class(name,room,begin_date,end_date,master_id,create_time,update_time,subject,status) " +
    "values(#{name},#{room},#{beginDate},#{endDate},#{masterId},#{createTime},#{updateTime},#{subject},#{status})")
    void save(Clazz clazz);

    @Select("select id,name,room,begin_date,end_date,master_id,subject,create_time,update_time from class where id=#{id}")
    ClazzIdQueryParam getById(Integer id);

    void update(Clazz clazz);
}
