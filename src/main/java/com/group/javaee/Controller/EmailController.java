package com.group.javaee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class EmailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/sendEmail")
    @ResponseBody
    public boolean sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("1412736935@qq.com");
        msg.setBcc();


        msg.setTo("429579723@qq.com");
        msg.setSubject("学业预警通知");
        msg.setText("同学你好：" +
                "本学期你未能满足培养方案基本要求，你被预警\n" +
                "                                 教务处" +
                new Date());
        try {
            javaMailSender.send(msg);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
