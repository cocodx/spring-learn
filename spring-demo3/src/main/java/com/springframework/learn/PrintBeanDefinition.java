package com.springframework.learn;

import com.alibaba.fastjson.JSON;
import com.springframework.learn.controller.StudentControllerProperties;
import com.springframework.learn.service.StudentService;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.util.Assert;

/**
 * Hello world!
 *
 */
public class PrintBeanDefinition
{
    public static void main( String[] args )
    {
        //1、使用默认的beanFactory，DefaultListableBeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2、使用BeanDefinitionBuilder，生成BeanDefinition,使用BeanNameGenerator生成beanName
        GenericBeanDefinition serviceBeanDefinition = (GenericBeanDefinition) BeanDefinitionBuilder.genericBeanDefinition(com.springframework.learn.service.StudentServiceImpl.class)
                .getBeanDefinition();
        String serviceName = AnnotationBeanNameGenerator.INSTANCE.generateBeanName(serviceBeanDefinition,beanFactory);

        //3、注册进去
        beanFactory.registerBeanDefinition(serviceName,serviceBeanDefinition);

        StudentService studentService = (StudentService) beanFactory.getBean(serviceName);
        studentService.get("007无限赴死");

        //构造StudentControllerProperties，通过set()方法注册进去
        GenericBeanDefinition controllerPropertiesBeanDefinition = (GenericBeanDefinition) BeanDefinitionBuilder.
                genericBeanDefinition(com.springframework.learn.controller.StudentControllerProperties.class)
                .addPropertyValue("name","named controller properties")
                .addPropertyValue("age","25")
                .addPropertyReference("studentService",serviceName)
                .getBeanDefinition();
        String controllerPropertiesBeanName = AnnotationBeanNameGenerator.INSTANCE.generateBeanName(controllerPropertiesBeanDefinition,beanFactory);
        beanFactory.registerBeanDefinition(controllerPropertiesBeanName,controllerPropertiesBeanDefinition);
        StudentControllerProperties controllerProperties = (StudentControllerProperties) beanFactory.getBean(controllerPropertiesBeanName);
        Assert.isTrue(studentService==controllerProperties.getStudentService(),"不相同service");

        //！！！！！！！！！！！！！！，不用看上面的，打印beanDefinition
        //5.3.14是可以正常打印出来的，之前是有bug，不能打印出来
        System.out.println(JSON.toJSONString(serviceBeanDefinition));
        System.out.println(JSON.toJSONString(controllerPropertiesBeanDefinition));
    }
}
