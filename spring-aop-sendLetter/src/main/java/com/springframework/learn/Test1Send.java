package com.springframework.learn;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URL;

/**
 * @author amazfit
 * @date 2022-07-07 上午12:27
 **/
@Component
public class Test1Send {

    public void send1() throws Exception {
        // Create the email message
        try{
            HtmlEmail email = new HtmlEmail();
            email.setHostName("mail.myserver.com");
            email.addTo("jdoe@somewhere.org", "John Doe");
            email.setFrom("me@apache.org", "Me");
            email.setSubject("Test email with inline image");

            // embed the image and get the content id
            URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
            String cid = email.embed(url, "Apache logo");

            // set the html message
            email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

            // set the alternative message
            email.setTextMsg("Your email client does not support HTML messages");

            // send the email
            email.send();
        }catch (Exception e){
            throw new Exception("htmlEmail的json数据");
        }
    }

    public void send2() throws Exception {
        // Create the email message
        HtmlEmail email = new HtmlEmail();
        email.setHostName("mail.myserver.com");
        email.addTo("jdoe@somewhere.org", "John Doe");
        email.setFrom("me@apache.org", "Me");
        email.setSubject("Test email with inline image");

        // embed the image and get the content id
        URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
        String cid = email.embed(url, "Apache logo");

        // set the html message
        email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

        // set the alternative message
        email.setTextMsg("Your email client does not support HTML messages");

        // send the email
        email.send();
    }

    public static void main(String[] args) throws Exception {
        Test1Send test1Send = new Test1Send();
        test1Send.send1();
    }
}
