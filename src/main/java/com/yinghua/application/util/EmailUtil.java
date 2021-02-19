package com.yinghua.application.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class EmailUtil {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    public int doEmail(String userEmail){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("肌哩肌哩邮箱验证登录");

        int emailCode = contextLoads3();
        simpleMailMessage.setText("验证码为:"+emailCode);

        simpleMailMessage.setTo(userEmail); //发送到这个邮箱

        simpleMailMessage.setFrom("1918652173@qq.com");//来自这个邮箱的发送

        javaMailSender.send(simpleMailMessage);
        return emailCode;
    }

    /**
     * 随机的6位数
     * */
    int contextLoads3() {
        Random random = new Random();
        int randomInt =random.nextInt(1000001)+100000;
        return  randomInt;
    }

}
