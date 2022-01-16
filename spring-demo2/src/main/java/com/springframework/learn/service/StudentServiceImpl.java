package com.springframework.learn.service;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 16/1/2022 上午7:52
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public void insert(String name) {
        System.out.println(String.format("插入name：%s，的数据",name));
    }

    @Override
    public void update(String name) {
        System.out.println(String.format("更新name：%s，的数据",name));
    }

    @Override
    public void delete(String name) {
        System.out.println(String.format("删除name：%s，的数据",name));
    }

    @Override
    public void get(String name) {
        System.out.println(String.format("查询name：%s，的数据",name));
    }
}
