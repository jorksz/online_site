package com.online.site.start.controller;

import com.online.site.start.entity.History;
import com.online.site.start.entity.Message;
import com.online.site.start.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/{userId}")
    public List<Message> listMessage(@PathVariable Integer userId){
        return messageService.listMessage(userId);
    }
}
