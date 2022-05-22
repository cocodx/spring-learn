package com.springframework.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 测试list的stream去重
 * @date 15/3/2022 上午11:37
 */
public class ListStreamDistinct
{
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"张三","男"));
        list.add(new Student(1,"lisi","男"));
        list.add(new Student(2,"王五","男"));
        list.add(new Student(3,"赵六","男"));
        list.add(new Student(4,"张三","男"));
        Map<String,List<Student>> listMap = new HashMap<>();
        listMap.put("1",list);
        listMap.put("2",list);
        listMap.put("3",list);

        for (String key:listMap.keySet()){
            List<Student> list1 = listMap.get(key);
            listMap.put(key,list1.stream().distinct().collect(Collectors.toList()));
        }

        List<Student> list1 = null;
    }
}
