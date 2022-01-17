package com.springframework.learn;

import com.springframework.learn.entity.Salesrep;

/**
 * Hello world!
 * 使用 PropertiesPathApplicationContext 读取 beanDefinition
 */
public class App 
{
    public static void main( String[] args )
    {
        PropertiesPathApplicationContext applicationContext = new PropertiesPathApplicationContext(
                new String[]{"beanDefinition.properties"},true,null);

        Salesrep salesrep = (Salesrep) applicationContext.getBean("salesrep");
        System.out.println(salesrep.getDepartment());
    }
}
