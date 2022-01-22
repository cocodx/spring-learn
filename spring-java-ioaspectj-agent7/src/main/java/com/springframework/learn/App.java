package com.springframework.learn;

import com.springframework.learn.service.TargetService;

/**
 * Hello world!
 * 测试类
 */
public class App 
{
    public static void main( String[] args )
    {
        TargetService targetService = new TargetService();
        //进展顺利，这处调用会被增强
        targetService.calculate();
    }
}
