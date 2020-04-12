package com.online.site.start.service;

import com.online.site.start.entity.Mail;

public interface MailService {

    /**
     * 保存邮件信息
     * @param mailNumber 邮箱
     * @return
     */
    boolean saveMail(String mailNumber);
}
