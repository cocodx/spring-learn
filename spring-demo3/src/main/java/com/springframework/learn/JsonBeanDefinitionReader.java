package com.springframework.learn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.NamedThreadLocal;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author εε
 * @version 1.0
 * @description
 * @date 16/1/2022 δΈε9:09
 */
public class JsonBeanDefinitionReader extends AbstractBeanDefinitionReader {
    private final ThreadLocal<Set<EncodedResource>> resourcesCurrentlyBeingLoaded;

    protected JsonBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
        this.resourcesCurrentlyBeingLoaded = new NamedThreadLocal<Set<EncodedResource>>("XML bean definition resources currently being loaded") {
            protected Set<EncodedResource> initialValue() {
                return new HashSet(4);
            }
        };
    }

    @Override
    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        Set<EncodedResource> currentResources = (Set)this.resourcesCurrentlyBeingLoaded.get();
        String jsonStr=null;
        try{
            EncodedResource encodedResource = new EncodedResource(resource);
            InputStream inputStream = encodedResource.getResource().getInputStream();
            jsonStr = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
//            System.out.println(jsonStr);
        }catch (IOException var26) {
            throw new BeanDefinitionStoreException("IOException parsing Json document from " + resource, var26);
        } finally {
            currentResources.remove(resource);
            if (currentResources.isEmpty()) {
                this.resourcesCurrentlyBeingLoaded.remove();
            }

        }

        //ζ­£εΈΈζ₯θ―΄οΌθΏιδΌζ₯ι
        //public org.springframework.beans.PropertyValue(org.springframework.beans.PropertyValue,java.lang.Object)
        //ηΆεοΌζθͺε·±ζδΊδΈδΈͺ5.2.2.RELEASEεοΌζPropertyValueοΌηnameεvalueοΌηfinalδΏ?ι₯°η»ε»ζδΊοΌηΆεε δΊδΈδΈͺι»θ?€ηζι ε½ζ°οΌζδ»₯ει’ζε°±θ¦θͺε·±εε propertyValue
        List<GenericBeanDefinition> listBeanDefinitions = JSON.parseArray(jsonStr,GenericBeanDefinition.class);
        if (listBeanDefinitions.size()==0){
            return 0;
        }

        for (int i = 0; i < listBeanDefinitions.size(); i++) {
            GenericBeanDefinition beanDefinition = listBeanDefinitions.get(i);

            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
            if (!propertyValues.isEmpty()){
                Class targetClass = null;
                try{
                    targetClass = Class.forName(beanDefinition.getBeanClassName());
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }

                Field[] fileds = targetClass.getDeclaredFields();

                for (int j = 0; j < propertyValues.getPropertyValueList().size(); j++) {
                    Field fields = fileds[j];
                    PropertyValue propertyValue=null;
                    //θΏιε°±ζ―εζ­»ηοΌε¦ζζ£ζ΅ε°studentService
                    if (fields.getName().contains("Service")){
                        propertyValue = new PropertyValue(fields.getName(),new RuntimeBeanReference("com.springframework.learn.service.StudentServiceImpl#0"));
                    }else{
                        propertyValue = new PropertyValue(fields.getName(),"1111111");
                    }
                    mutablePropertyValues.addPropertyValue(propertyValue);
                }
                beanDefinition.setPropertyValues(mutablePropertyValues);
            }

            BeanNameGenerator beanNameGenerator = getBeanNameGenerator();
            String name = beanNameGenerator.generateBeanName(beanDefinition,getRegistry());
            getRegistry().registerBeanDefinition(name,beanDefinition);
        }


        return listBeanDefinitions.size();
    }
}
