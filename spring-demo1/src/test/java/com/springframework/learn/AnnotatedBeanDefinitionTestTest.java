package com.springframework.learn;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.util.ClassUtils;

/**
 * Unit test for simple App.
 */
public class AnnotatedBeanDefinitionTestTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void loadClass() throws ClassNotFoundException {
        //初始化给定的类
        Class<?> resolvedClass = ClassUtils.forName("com.springframework.learn.readjson.properties.Salesrep", Thread.currentThread().getContextClassLoader());
        System.out.println(resolvedClass);
    }
}
