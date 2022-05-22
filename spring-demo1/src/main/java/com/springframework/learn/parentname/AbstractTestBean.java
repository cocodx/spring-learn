package com.springframework.learn.parentname;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 9/3/2022 下午10:46
 */
@Data
@ToString
public abstract class AbstractTestBean {

    private String name;
    private int age;

    public AbstractTestBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public AbstractTestBean() {
    }
}
