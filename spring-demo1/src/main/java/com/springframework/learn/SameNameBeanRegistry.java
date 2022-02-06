package com.springframework.learn;

import com.springframework.learn.service.AnotherStudentService;
import com.springframework.learn.service.StudentService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘刚
 * @version 1.0
 * @description 测试同名bean的注册
 * @date 16/1/2022 上午7:24
 */
public class SameNameBeanRegistry {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"beanDefinition.xml"},false,null);
        //配置：允许同名beanName的bean覆盖.默认true,Springboot里面默认是false
        applicationContext.setAllowBeanDefinitionOverriding(false);
        applicationContext.refresh();

        //get work 测试：studentService是否注册进去， ok
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.studentName("007");

        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();

        //将同名的beanName：studentService，AnotherStudentService注册进去
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(com.springframework.learn.service.AnotherStudentService.class);
        beanFactory.registerBeanDefinition("studentService",beanDefinition);

        //测试：是否获取的是AnotherStudentService
        AnotherStudentService studentService1 = (AnotherStudentService) applicationContext.getBean("studentService");
        studentService1.studentName1("007");

    }
}
