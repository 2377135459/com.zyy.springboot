package com.springboot.demo.util.MailUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class MailServiceUtil {
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendVertifyCode(String to, String title, String content) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from); //发送人
            message.setTo(to);   //收件人
            message.setSubject(title);  //邮件名
            message.setText(content);   //邮件内容
            mailSender.send(message);
            logger.info("邮件发送成功" + to + ":" + content);
        } catch (Exception e) {
            logger.info("邮件发送失败" + e);
        }

    }
}
