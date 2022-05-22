package com.springframework.learn;

import com.springframework.learn.service.StudentService;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class AnnotatedBeanDefinitionTest
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("xml");
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext
                ("com.springframework.learn");
        AnnotatedBeanDefinition studentServiceBeanDefinition = (AnnotatedBeanDefinition) configApplicationContext.getBeanDefinition("studentServiceImpl");

        AnnotationMetadata metadata = studentServiceBeanDefinition.getMetadata();
        Map<String,Object> resultQ = metadata.getAnnotationAttributes("org.springframework.stereotype.Service");
        System.out.println(resultQ.get("value"));
    }
}
