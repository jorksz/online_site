package com.online.site.start.service.impl;

import com.online.site.start.entity.Mail;
import com.online.site.start.mapper.MailMapper;
import com.online.site.start.properties.StringProperties;
import com.online.site.start.service.MailService;
import com.online.site.start.service.SendMailService;
import com.online.site.start.utils.RandomVerCode;
import com.online.site.start.utils.TimeTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailMapper mailMapper;

    @Autowired
    private SendMailService sendSimpleMail;

    @Override
    public boolean saveMail(String mailNumber) {
        String valiCode = RandomVerCode.achieveCode();
        String content = StringProperties.MAIL_CONTENT + valiCode;
        Mail mail = new Mail();
        mail.setTitle(StringProperties.MAIL_TITLE);
        mail.setContent(content);
        String startTime = TimeTransform.nowDateTrans(new Date());
        mail.setStartTime(startTime);
        mail.setEndTime(TimeTransform.nextTenMiDateTrans(startTime));
        mail.setToMailNumber(mailNumber);
        mail.setVerificationCode(valiCode);

        //发送邮件
        sendSimpleMail.sendSimpleMail(mailNumber, content, StringProperties.MAIL_TITLE);
        return mailMapper.saveMail(mail) > 0;
    }
}
