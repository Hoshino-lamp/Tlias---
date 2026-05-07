package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
    private Integer id;
    private String name;//班级名称
    private String room;//班级教室
    private String beginDate;//班级开始时间
    private String endDate;//班级结束时间
    private Integer masterId;//班级班主任
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
    private String status;//状态 未开班，已开班，已结课

    private String masterName;//班主任名称
    private Integer subject;//科目1,2,3,4,5,6,
}
