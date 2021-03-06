package com.springframework.learn.controller;

import com.springframework.learn.service.StudentService;
import lombok.Data;

/**
 * @author εε
 * @version 1.0
 * @description
 * @date 16/1/2022 δΈε7:55
 */
@Data
public class StudentControllerProperties {

    private StudentService studentService;
    private String name;
    private Integer age;

}
