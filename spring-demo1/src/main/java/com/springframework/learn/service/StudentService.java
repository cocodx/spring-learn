package com.springframework.learn.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author εε
 * @version 1.0
 * @description
 * @date 14/1/2022 δΈε2:01
 */
@Qualifier("qualifierStudent")
@Service("studentServiceImpl")
public class StudentService {

    public void studentName(String name){
        System.out.println(name);
    }
}
