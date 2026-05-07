package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;//学生id
    private String name;//学生姓名
    private String no;//学号
    private Integer gender;// 性别（1：男 2：女）
    private String phone;//手机号
    private Integer degree;//学历（1：初中 2：高中 3：大专 4：本科 5：硕士 6：博士）
    private String idCard;//身份证号码
    private Integer isCollege;//是否是院校学生（1是 0否）
    private String address;// 联系地址
    private LocalDate graduationDate;//毕业时间
    private Integer violationCount=0;//违规次数
    private Integer violationScore=0;//违规分数
    private Integer clazzId;//班级id
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间

    private String clazzName;//班级名称
}
