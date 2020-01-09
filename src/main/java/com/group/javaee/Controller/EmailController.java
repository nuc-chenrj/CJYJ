package com.group.javaee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
public class EmailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/sendEmail")
    @ResponseBody
    public void sendEmail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();


        String[] array = request.getParameterValues( "email");
        System.out.println(array);

        for(int i=0;i<array.length;i++){
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("1412736935@qq.com");
            msg.setBcc();

            msg.setTo(array[i]);
            msg.setSubject("学业预警通知");
            msg.setText("同学你好：" +
                    "本学期你未能满足培养方案基本要求，你被预警\n" +
                    "                                 教务处" +
                    new Date());
            try {
                javaMailSender.send(msg);
            } catch (MailException ex) {
                System.err.println(ex.getMessage());

                out.println("<script> alert(\"发送失败!\"); </script>");
                response.setHeader("refresh", "1;URL=adminPage");
            }

        }

        out.println("<script> alert(\"发送成功!\"); </script>");
        response.setHeader("refresh", "1;URL=adminPage");
    }
}

