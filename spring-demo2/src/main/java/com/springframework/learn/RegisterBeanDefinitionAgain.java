package com.springframework.learn;

import com.springframework.learn.controller.StudentControllerConstructor;
import com.springframework.learn.controller.StudentControllerProperties;
import com.springframework.learn.service.StudentService;
import com.springframework.learn.service.StudentServiceImpl;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.util.Assert;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 再次手动注册BeanDefinition
 * @date 9/3/2022 下午11:55
 */
public class RegisterBeanDefinitionAgain {

    public static void main(String[] args) {
        //1、选择一个容器BeanFactory的实现
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2、获取BeanName
        //2.1、注入StudentServiceImpl的BeanDefinition
        GenericBeanDefinition genericBeanDefinition1 = (GenericBeanDefinition) BeanDefinitionBuilder.genericBeanDefinition(StudentServiceImpl.class).getBeanDefinition();
        String serviceName = AnnotationBeanNameGenerator.INSTANCE.generateBeanName(genericBeanDefinition1,beanFactory);
        System.out.println("驼峰serviceName："+serviceName);
        beanFactory.registerBeanDefinition(serviceName,genericBeanDefinition1);
        //2.2、构建StudentControllerProperties的BeanDefinition，同时property方式set注入studentService的BeanDefinition依赖
        GenericBeanDefinition genericBeanDefinition2 = (GenericBeanDefinition) BeanDefinitionBuilder.genericBeanDefinition(StudentControllerProperties.class)
                .addPropertyValue("name","property values")
                .addPropertyValue("age","100")
                .addPropertyReference("studentService",serviceName)
                .getBeanDefinition();
        String beanName = AnnotationBeanNameGenerator.INSTANCE.generateBeanName(genericBeanDefinition2,beanFactory);
        System.out.println("驼峰beanName："+beanName);
        String beanName1 = DefaultBeanNameGenerator.INSTANCE.generateBeanName(genericBeanDefinition2,beanFactory);
        System.out.println("#0beanName:"+beanName1);
        beanFactory.registerBeanDefinition(beanName,genericBeanDefinition2);

        StudentService studentService = (StudentService) beanFactory.getBean(serviceName);
        StudentControllerProperties studentControllerProperties = (StudentControllerProperties) beanFactory.getBean(beanName);

        Assert.isTrue(studentService==studentControllerProperties.getStudentService(),"卧槽，这还不是相等的吗！");
        System.out.println(studentService.hashCode());
        System.out.println(studentControllerProperties.getStudentService().hashCode());

        //3.1 constructorArgumentValues注入
        GenericBeanDefinition genericBeanDefinition3 = (GenericBeanDefinition) BeanDefinitionBuilder.genericBeanDefinition(StudentControllerConstructor.class)
                .addConstructorArgReference(serviceName)
                .addConstructorArgValue("constructor")
                .addConstructorArgValue("222")
                .getBeanDefinition();
        String beanName3 = DefaultBeanNameGenerator.INSTANCE.generateBeanName(genericBeanDefinition3,beanFactory);
        System.out.println("beanName3："+beanName3);
        beanFactory.registerBeanDefinition(beanName3,genericBeanDefinition3);
        StudentControllerConstructor controllerConstructor = (StudentControllerConstructor) beanFactory.getBean(beanName3);
        System.out.println("构造器注入，service的hashcode："+controllerConstructor.getStudentService().hashCode());
    }
}
