package com.online.site.start.service.impl;

import com.online.site.start.properties.StringProperties;
import com.online.site.start.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMail(String to, String content, String title) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(StringProperties.FORM); // 邮件发送者
        message.setTo(to); // 邮件接受者
        message.setSubject(title); // 主题
        message.setText(content); // 内容
        javaMailSender.send(message);
    }
}
