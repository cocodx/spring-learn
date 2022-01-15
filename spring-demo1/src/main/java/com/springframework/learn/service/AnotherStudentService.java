package com.springframework.learn.service;

/**
 * @author 刘刚
 * @version 1.0
 * @description 用这个类，去上下文里面注册同名的bean
 * @date 16/1/2022 上午7:23
 */
public class AnotherStudentService {
    public void studentName1(String name){
        System.out.println(name+",AnotherStudentService");
    }
}
