package com.online.site.start.service;

import com.online.site.start.entity.Message;

import java.util.List;

public interface MessageService {

    /**
     * 查询信息
     * @param userId 用户id
     * @return
     */
    List<Message> listMessage(Integer userId);

    /**
     * 保存信息
     * @param message
     * @return
     */
    boolean saveMessage(Message message);
}
