package com.online.site.start.service;

import com.online.site.start.entity.Mail;

public interface MailService {

    /**
     * 保存邮件信息
     * @param mail
     * @return
     */
    boolean saveMail(Mail mail);
}
