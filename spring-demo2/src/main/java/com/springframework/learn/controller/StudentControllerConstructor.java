package com.springframework.learn.controller;

import com.springframework.learn.service.StudentService;

/**
 * @author εε
 * @version 1.0
 * @description
 * @date 16/1/2022 δΈε7:55
 */
public class StudentControllerConstructor {

    private StudentService studentService;
    private String name;
    private Integer age;

    public StudentControllerConstructor(StudentService studentService, String name, Integer age) {
        this.studentService = studentService;
        this.name = name;
        this.age = age;
    }

    public StudentService getStudentService() {
        return studentService;
    }
}
