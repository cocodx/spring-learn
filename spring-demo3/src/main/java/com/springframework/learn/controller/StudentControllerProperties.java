package com.springframework.learn.controller;

import com.springframework.learn.service.StudentService;

/**
 * @author εε
 * @version 1.0
 * @description
 * @date 16/1/2022 δΈε7:55
 */
public class StudentControllerProperties {

    private StudentService studentService;
    private String name;
    private Integer age;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
