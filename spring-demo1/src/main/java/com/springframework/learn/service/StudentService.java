package com.springframework.learn.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 14/1/2022 上午2:01
 */
@Qualifier("qualifierStudent")
@Service("studentServiceImpl")
public class StudentService {

    public void studentName(String name){
        System.out.println(name);
    }
}
