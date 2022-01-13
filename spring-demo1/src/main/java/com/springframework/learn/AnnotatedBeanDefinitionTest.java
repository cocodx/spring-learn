package com.springframework.learn;

import com.springframework.learn.service.StudentService;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext
                ("com.springframework.learn");
        AnnotatedBeanDefinition studentServiceBeanDefinition = (AnnotatedBeanDefinition) configApplicationContext.getBeanDefinition("studentServiceImpl");

        AnnotationMetadata metadata = studentServiceBeanDefinition.getMetadata();
        Map<String,Object> resultQ = metadata.getAnnotationAttributes("org.springframework.beans.factory.annotation.Qualifier");
        System.out.println(resultQ.get("value"));
    }
}
