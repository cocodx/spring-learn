package com.springframework.learn;

import com.springframework.learn.service.TargetClass;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 22/1/2022 下午12:44
 */
public class TestMainJar {

    public static void main(String[] args) {
        System.out.println("TestMainJar!!! main()");
        new TargetClass().sayHello();
    }
}
