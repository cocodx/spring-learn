package com.springframework.learn.service;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 16/1/2022 上午7:51
 */
public interface StudentService {

    void insert(String name);
    void update(String name);
    void delete(String name);
    void get(String name);
}
