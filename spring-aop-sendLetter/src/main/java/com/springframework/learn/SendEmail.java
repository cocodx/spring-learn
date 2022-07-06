package com.springframework.learn;

import org.springframework.stereotype.Component;

/**
 * @author amazfit
 * @date 2022-07-07 上午12:31
 **/
@Component
public class SendEmail {

    public void preSend(){
        System.out.println("获取HtmlEmail进行发送邮件");
    }
}
