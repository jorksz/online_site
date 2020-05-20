package com.online.site.start.mapper;

import com.online.site.start.entity.Mail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MailMapper {

    /**
     * 保存信息
     * @param mail
     * @return
     */
    Integer saveMail(Mail mail);

    /**
     * 根据验证码查询邮件信息
     * @param verCode
     * @return
     */
    List<Mail> listMail(String verCode);
}
