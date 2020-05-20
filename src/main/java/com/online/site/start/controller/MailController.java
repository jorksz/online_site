package com.online.site.start.controller;

import com.online.site.start.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/{mailNumber}")
    public boolean saveMail(@PathVariable String mailNumber){
        return mailService.saveMail(mailNumber);
    }

    @RequestMapping(value = "/check/{verCode}")
    public boolean checkVerCode(@PathVariable String verCode){
        return mailService.checkMail(verCode);
    }

}
