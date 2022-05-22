package com.springframework.learn.readjson.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;

import java.io.IOException;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 上下文
 * @date 10/3/2022 下午10:22
 */
public class ClassPathJsonApplicationContext extends AbstractRefreshableConfigApplicationContext {


    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
        JsonBeanDefinitionReader beanDefinitionReader = new JsonBeanDefinitionReader(beanFactory);

        beanDefinitionReader.setEnvironment(this.getEnvironment());
        beanDefinitionReader.setResourceLoader(this);
        loadBeanDefinitions(beanDefinitionReader);
    }

    private void loadBeanDefinitions(JsonBeanDefinitionReader beanDefinitionReader) {
        String[] configurations = getConfigLocations();
        if (configurations!=null){
            beanDefinitionReader.loadBeanDefinitions(configurations);
        }
    }

    public ClassPathJsonApplicationContext(String configuration)throws BeansException{
        this(new String[]{configuration},true,null);
    }

    public ClassPathJsonApplicationContext(String[] configuration,boolean refresh,ApplicationContext parent)throws BeansException{
        super(parent);
        setConfigLocations(configuration);
        if (refresh){
            refresh();
        }
    }
}
