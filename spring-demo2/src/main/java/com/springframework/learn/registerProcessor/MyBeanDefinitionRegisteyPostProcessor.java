package com.springframework.learn.registerProcessor;

import com.springframework.learn.log.MyLog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * 使用时机，就是在 beandefinition 还没有加载之前，做些小动作
 * @date 13/3/2022 上午2:44
 */
@Component
public class MyBeanDefinitionRegisteyPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegisteyPostProcessor ------------ postProcessBeanDefinitionRegistry");
        System.out.println("bean定义数量："+registry.getBeanDefinitionCount());
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(MyLog.class);
        registry.registerBeanDefinition("mylog---",rootBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
