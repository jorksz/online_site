package com.online.site.start.mapper;

import com.online.site.start.entity.Mail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailMapper {

    /**
     * 保存信息
     * @param mail
     * @return
     */
    Integer saveMail(Mail mail);
}
