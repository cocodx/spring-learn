package com.springframework.learn.readxml;

import com.springframework.learn.entity.Coder;
import com.springframework.learn.entity.Girl;
import com.springframework.learn.entity.TwoTuple;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用sax解析xml文件 coder.xml
 */
public class SaxXmlAnalysis extends DefaultHandler {

    private LinkedList<Object> stack = new LinkedList<>();

    private AtomicInteger eventOrderCounter = new AtomicInteger(0);

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("startElement: "+qName  +" It is the "+ eventOrderCounter.getAndIncrement());

        if ("Coder".equals(qName)){
            Coder coder = new Coder();
//            coder.setName(attributes.getValue("name"));
//            coder.setSex(attributes.getValue("sex"));
//            coder.setLove(attributes.getValue("love"));
            setProperties(attributes,coder);
            stack.push(coder);
        }else if ("girl".equals(qName)){
            Girl girl = new Girl();

            //手动设置属性的缺点，在xml里面增加属性，这里代码也要变
//            girl.setName(attributes.getValue("name"));
//            girl.setBreast(attributes.getValue("breast"));
//            girl.setHeight(attributes.getValue("height"));
//            girl.setLegLength(attributes.getValue("legLength"));
            setProperties(attributes,girl);

            Coder coder = (Coder) stack.peek();
            coder.setGirl(girl);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("endElement: "+qName  +" It is the "+ eventOrderCounter.getAndIncrement());

        if ("Coder".equals(qName)){
            Object o = stack.pop();
            System.out.println(o);
        }
    }

    private void setProperties(Attributes attributes,Object object){
        Method[] methods = object.getClass().getMethods();
        ArrayList<Method> list = new ArrayList<>();
        list.addAll(Arrays.asList(methods));
        list.removeIf(o -> o.getParameterCount() != 1);

        for (int i = 0; i < attributes.getLength(); i++) {
            //获取属性名
            String atributesQName = attributes.getQName(i);
            String setterMethod = "set"+atributesQName.substring(0,1).toUpperCase()+atributesQName.substring(1);

            String value = attributes.getValue(i);
            TwoTuple<Method,Object[]> tuple =  getSuitableMethod(list, setterMethod, value);
            // 没有找到合适的方法
            if (tuple == null) {
                continue;
            }

            Method method = tuple.first;
            Object[] params = tuple.second;
            try {
                method.invoke(object,params);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private TwoTuple<Method,Object[]> getSuitableMethod(List<Method> list, String setterMethod, String value) {
        for (Method method : list) {

            if (!Objects.equals(method.getName(), setterMethod)) {
                continue;
            }

            Object[] params = new Object[1];

            /**
             * 1；如果参数类型就是String，那么就是要找的
             */
            java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> parameterType = parameterTypes[0];
            if (parameterType.equals(String.class)) {
                params[0] = value;
                return new TwoTuple<>(method,params);
            }

            Boolean ok = true;

            // 看看int是否可以转换
            String name = parameterType.getName();
            if (name.equals("java.lang.Integer")
                    || name.equals("int")){
                try {
                    params[0] = Integer.valueOf(value);
                }catch (NumberFormatException e){
                    ok = false;
                    e.printStackTrace();
                }
                // 看看 long 是否可以转换
            }else if (name.equals("java.lang.Long")
                    || name.equals("long")){
                try {
                    params[0] = Long.valueOf(value);
                }catch (NumberFormatException e){
                    ok = false;
                    e.printStackTrace();
                }
                // 如果int 和 long 不行，那就只有尝试boolean了
            }else if (name.equals("java.lang.Boolean") ||
                    name.equals("boolean")){
                params[0] = Boolean.valueOf(value);
            }

            if (ok){
                return new TwoTuple<Method,Object[]>(method,params);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SaxXmlAnalysis analysis = new SaxXmlAnalysis();

        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser parser = spf.newSAXParser();
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("coder.xml");
            parser.parse(inputStream,analysis);
        }catch (ParserConfigurationException | SAXException | IOException exception){
            exception.printStackTrace();
        }
    }
}
