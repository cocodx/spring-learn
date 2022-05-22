package com.springframework.learn.controller;

import com.springframework.learn.service.StudentService;
import lombok.Data;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 16/1/2022 上午7:55
 */
@Data
public class StudentControllerProperties {

    private StudentService studentService;
    private String name;
    private Integer age;

}
