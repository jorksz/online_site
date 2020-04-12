package com.online.site.start.service;

public interface SendMailService {

    /**
     * 发送纯文本邮件
     * @param to 接受方
     * @param content 邮件内容
     * @param title 邮件标题
     */
    void sendSimpleMail(String to, String content, String title);
}
