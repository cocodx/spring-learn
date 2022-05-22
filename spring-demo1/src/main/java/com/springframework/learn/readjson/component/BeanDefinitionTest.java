package com.springframework.learn.readjson.component;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 用来再反序列化json，存ConstructorArgumentValuesTest
 * @date 11/3/2022 上午12:54
 */
public class BeanDefinitionTest {

    private ConstructorArgumentValuesTest constructorArgumentValues;

    private String beanClassName;

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public ConstructorArgumentValuesTest getConstructorArgumentValues() {
        return constructorArgumentValues;
    }

    public void setConstructorArgumentValues(ConstructorArgumentValuesTest constructorArgumentValues) {
        this.constructorArgumentValues = constructorArgumentValues;
    }
}
