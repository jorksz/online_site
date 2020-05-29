package com.online.site.start.controller;

import com.online.site.start.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/view")
public class ViewUserController {


    @RequestMapping("user/usmg")
    public String userMessage(Model model, HttpSession session){
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "/user/person_message";
    }

    @RequestMapping("/user/message")
    public String comment(Model model, HttpSession session){
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "/user/message";
    }

    @RequestMapping("/user/history")
    public String history(Model model, HttpSession session){
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "/user/history";
    }

    @RequestMapping("/user/collection")
    public String collection(Model model, HttpSession session){
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "/user/collection";
    }


}
