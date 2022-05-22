package com.springframework.learn;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 测试事件监听器
 * @date 13/3/2022 上午2:03
 */
public class TestApplicationListener {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        context.publishEvent(new ApplicationEvent("我手动发布了一个事件") {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
        context.close();
    }
}
