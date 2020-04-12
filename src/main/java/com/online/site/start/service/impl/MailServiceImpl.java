package com.online.site.start.service.impl;

import com.online.site.start.entity.Mail;
import com.online.site.start.mapper.MailMapper;
import com.online.site.start.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailMapper mailMapper;

    @Override
    public boolean saveMail(Mail mail) {
        return mailMapper.saveMail(mail) > 0;
    }
}
