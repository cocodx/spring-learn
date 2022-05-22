package com.springframework.learn.factoryprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * 触发时候：在beanDefinition都加载到容器中去了，但是还没有实例化的时候
 * @date 13/3/2022 上午2:20
 */
@Component
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("IOC容器调用了MyBeanFactoryProcessor");
        for (String name:beanFactory.getBeanDefinitionNames()){
            if (name.equals("studentServiceImpl")){
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
                beanDefinition.setLazyInit(true);
            }
        }
    }
}
