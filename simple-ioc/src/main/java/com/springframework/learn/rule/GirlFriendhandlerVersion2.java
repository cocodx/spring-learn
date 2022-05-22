package com.springframework.learn.rule;

import com.springframework.learn.rule.impl.CreateObjectParseRule;
import com.springframework.learn.rule.impl.SetPropertiesParseRule;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GirlFriendhandlerVersion2 extends DefaultHandler {
    private AtomicInteger eventOrderCounter = new AtomicInteger(0);
    private LinkedList<Object> stack = new LinkedList<>();

    //每个元素可以有多个规则，所以value是一个list。解析时，会按顺序调用各个规则
    private ConcurrentHashMap<String, List<ParseRule>> ruleMap = new ConcurrentHashMap<>();

    {
        ArrayList<ParseRule> rules = new ArrayList<>();
        rules.add(new CreateObjectParseRule("class",this));
        rules.add(new SetPropertiesParseRule(this));

        ruleMap.put("Coder",rules);

        rules = new ArrayList<>();
        rules.add(new CreateObjectParseRule("class",this));
        rules.add(new SetPropertiesParseRule(this));

        ruleMap.put("Girl",rules);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("startElement: " + qName + " It's the " + eventOrderCounter.getAndIncrement() + " one");

       List<ParseRule> rules = ruleMap.get(qName);
        for (ParseRule rule : rules) {
            rule.startElement(attributes);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("endElement: " + qName + " It's the " + eventOrderCounter.getAndIncrement() + " one");

        List<ParseRule> rules = ruleMap.get(qName);
        if (rules != null) {
            for (ParseRule rule : rules) {
                rule.endElement();
            }
        }
    }

    /**
     * 栈内弹出栈顶对象
     * @return
     */
    public Object pop(){
        return stack.pop();
    }

    /**
     * 栈顶push元素
     * @param object
     */
    public void push(Object object){
        stack.push(object);
    }

    /**
     * 返回栈顶元素，但不弹出
     */
    public Object peek(){
        return stack.peek();
    }
}
