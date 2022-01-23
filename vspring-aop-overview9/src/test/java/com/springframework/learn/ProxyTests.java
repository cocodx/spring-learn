package com.springframework.learn;

import com.springframework.learn.jdkdemo1.MyInvocationHandler;
import com.springframework.learn.jdkdemo1.UserService;
import com.springframework.learn.jdkdemo1.UserServiceImpl;
import org.junit.Test;

/**
 * @author 刘刚
 * @version 1.0
 * @description 验证对于接口的增强是否起到作用
 * @date 24/1/2022 上午12:23
 */
public class ProxyTests {

    @Test
    public void testProxy() throws Throwable{
        //实例化目标对象
        UserService userService = new UserServiceImpl();
        //实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

        //根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();
        //调用代理对象的方法
        proxy.add();


    }
}
