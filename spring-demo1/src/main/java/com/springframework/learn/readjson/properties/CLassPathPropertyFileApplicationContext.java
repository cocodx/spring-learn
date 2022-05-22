package com.springframework.learn.readjson.properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;

import java.io.IOException;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 12/3/2022 上午3:37
 */
public class CLassPathPropertyFileApplicationContext extends AbstractRefreshableConfigApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
        //构造一个propertiesBeanDefinitionReader
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        beanDefinitionReader.setEnvironment(this.getEnvironment());
        beanDefinitionReader.setResourceLoader(this);

        loadBeanDefinitions(beanDefinitionReader);
    }

    private void loadBeanDefinitions(PropertiesBeanDefinitionReader beanDefinitionReader) {
        String[] configResources = getConfigLocations();
        if (configResources!=null){
            beanDefinitionReader.loadBeanDefinitions(configResources);
        }
    }

    public CLassPathPropertyFileApplicationContext(String[] configuratoins) {
        this(configuratoins,true,null);
    }

    public CLassPathPropertyFileApplicationContext(ApplicationContext parent) {
        super(parent);
    }

    public CLassPathPropertyFileApplicationContext(String configuratoin) {
        this(new String[]{configuratoin},true,null);
    }

    public CLassPathPropertyFileApplicationContext(String[] configuratoins,boolean refresh,ApplicationContext context) {
        super(context);
        setConfigLocations(configuratoins);
        if (refresh){
            refresh();
        }
    }

}
