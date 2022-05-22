package com.springframework.learn.readjson.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.core.NamedThreadLocal;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author 正能量导师
 * @version 1.0
 * @description json的beanDefinition阅读器
 * @date 10/3/2022 下午10:29
 */
@Slf4j
public class JsonBeanDefinitionReader extends AbstractBeanDefinitionReader {

    private final ThreadLocal<Set<EncodedResource>> resourcesCurrentlyBeingLoaded =
            new NamedThreadLocal<Set<EncodedResource>>("XML bean definition resources currently being loaded"){
                @Override
                protected Set<EncodedResource> initialValue() {
                    return new HashSet<>(4);
                }
            };

    protected JsonBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        Set<EncodedResource> currentResources = this.resourcesCurrentlyBeingLoaded.get();
        if (currentResources == null){
            currentResources = new HashSet<>(4);
            this.resourcesCurrentlyBeingLoaded.set(currentResources);
        }
        EncodedResource encodedResource = new EncodedResource(resource);
        if (!currentResources.add(encodedResource)){
            throw new BeanDefinitionStoreException(
                    "Detected cyclic loading of " + encodedResource + " - check your import definitions!");
        }
        String json = null;
        try(InputStream inputStream = encodedResource.getResource().getInputStream()){
            json = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
        }catch (IOException e){
            log.error("抛出异常：",e);
            return 0;
        }finally {
            currentResources.remove(encodedResource);
            if (currentResources.isEmpty()){
                this.resourcesCurrentlyBeingLoaded.remove();
            }
        }
        Map<String,Object> originMap = new HashMap<>();
        List<BeanDefinitionTest> list1 = JSON.parseArray(json,BeanDefinitionTest.class);
        if (!CollectionUtils.isEmpty(list1)){
            for (BeanDefinitionTest beanDefinitionTest:list1) {
                String key = beanDefinitionTest.getBeanClassName();
                ConstructorArgumentValuesTest constructorArgumentValuesTest = beanDefinitionTest.getConstructorArgumentValues();
                if (!constructorArgumentValuesTest.isEmpty()){
                    originMap.put(key,constructorArgumentValuesTest);
                }
            }
        }


        //熟悉的fastjson，熟悉的味道
        List<GenericBeanDefinition> list = JSON.parseArray(json,GenericBeanDefinition.class);
        if (CollectionUtils.isEmpty(list)){
            return 0;
        }
        /*
        1、因为GenericBeanDefinition，只有setBeanClassName，所以bean反序列化时，只序列化了这个字段
        beanClass很重要，还有单独处理
         */
        for(GenericBeanDefinition genericBeanDefinition:list){
            Class<?> clazz = null;
            try{
                clazz = Thread.currentThread().getContextClassLoader().loadClass(genericBeanDefinition.getBeanClassName());
            }catch (ClassNotFoundException e){
                log.error("bean class cant be load for beandefinition: {}",genericBeanDefinition);
                throw new RuntimeException();
            }
            genericBeanDefinition.setBeanClass(clazz);

            //TODO 自己定义一个map去存储 key为beanClassName，value为ConstructorArgumentValues。
            ConstructorArgumentValuesTest constructorArgumentValues = (ConstructorArgumentValuesTest) originMap.get(genericBeanDefinition.getBeanClassName());
            if (constructorArgumentValues==null){
                continue;
            }
//          ConstructorArgumentValues constructorArgumentValues = genericBeanDefinition.getConstructorArgumentValues();
            if (constructorArgumentValues.isEmpty()){
                continue;
            }
            ConstructorArgumentValues constructorArgumentValues1 = new ConstructorArgumentValues();
            BeanUtils.copyProperties(constructorArgumentValues,constructorArgumentValues1);
            for (Integer key:constructorArgumentValues.getIndexedArgumentValues().keySet()){
//                Object value = valueHolder.getValue();
                constructorArgumentValues1.addIndexedArgumentValue(key,constructorArgumentValues.getIndexedArgumentValues().get(key));
            }
            Map<Integer,ConstructorArgumentValues.ValueHolder> map = constructorArgumentValues1.getIndexedArgumentValues();
            if (CollectionUtils.isEmpty(map)){
                continue;
            }
            for (ConstructorArgumentValues.ValueHolder valueHolder:map.values()){
                Object value = valueHolder.getValue();
                JSONObject jsonObject = (JSONObject) JSONObject.toJSON(value);
//                JSONObject jsonObject1 = jsonObject.getJSONObject("value");
                RuntimeBeanReference runtimeBeanReference = new RuntimeBeanReference(jsonObject.getString("beanName"));
                valueHolder.setValue(runtimeBeanReference);
            }
            genericBeanDefinition.setConstructorArgumentValues(constructorArgumentValues1);
        }
        setBeanNameGenerator(new AnnotationBeanNameGenerator());
        BeanNameGenerator beanNameGenerator = getBeanNameGenerator();
        BeanDefinitionRegistry registry = getRegistry();
        for(GenericBeanDefinition beanDefinition:list){
            String beanName = beanNameGenerator.generateBeanName(beanDefinition,registry);
            registry.registerBeanDefinition(beanName,beanDefinition);
        }
        return list.size()


                ;
    }
}
