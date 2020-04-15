package com.online.site.start.service.impl;

import com.online.site.start.entity.Message;
import com.online.site.start.mapper.MessageMapper;
import com.online.site.start.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> listMessage(Integer userId) {
        return messageMapper.listMessage(userId);
    }

    @Override
    public boolean saveMessage(Message message) {
        return messageMapper.saveMessage(message) > 0;
    }
}
