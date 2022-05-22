package com.springframework.learn;

import com.springframework.learn.factoryprocessor.MyBeanFactoryProcessor;
import com.springframework.learn.listener.MyApplicationListener;
import com.springframework.learn.service.StudentService;
import com.springframework.learn.service.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 13/3/2022 上午1:14
 */
@Configuration
public class MainConfig {

//    @Bean
//    public StudentService studentService(){
//        return new StudentServiceImpl();
//    }
//
//    @Bean
//    public MyApplicationListener myApplicationListener(){
//        return new MyApplicationListener();
//    }
//
//    @Bean
//    public MyBeanFactoryProcessor myBeanFactoryProcessor(){
//        return new MyBeanFactoryProcessor();
//    }
}
