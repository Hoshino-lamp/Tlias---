package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/upload")
public class UploadController {
    //本地存储
//    @PostMapping
//    public Result handleFileUpload(String name, Integer age, MultipartFile file) throws IOException {
//        log.info("文件上传:{}",file);
//        //文件名获取
//        String originalFilename = file.getOriginalFilename();
//        String newFileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
//
//        //保存文件
//        file.transferTo(new File("E:/itheima/"+newFileName));
//        return Result.success();
//    }

    //阿里云存储
    @Autowired
    AliyunOSSOperator aliyunOSSOperator;

    @PostMapping
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传:{}",file.getOriginalFilename());
        String url=aliyunOSSOperator.upload( file.getBytes(), file.getOriginalFilename());
        return Result.success(url);
    }
}
