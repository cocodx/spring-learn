package com.springframework.learn.parentname;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 9/3/2022 下午10:47
 */
@Data
@ToString
public class TestBean extends AbstractTestBean {

    public TestBean(String name,int age) {
        super(name,age);
    }

    public TestBean() {
    }
}
