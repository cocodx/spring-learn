package com.springframework.learn;

import com.springframework.learn.controller.StudentControllerProperties;

/**
 * @author 刘刚
 * @version 1.0
 * @description 测试读取json文件
 * @date 16/1/2022 上午9:24
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        JsonPathApplicationContext applicationContext = new JsonPathApplicationContext(
                new String[]{"beanDefinition.json"},true,null
        );
        StudentControllerProperties controllerProperties = applicationContext.getBean(StudentControllerProperties.class);
        System.out.println(controllerProperties.getName());

    }
}
