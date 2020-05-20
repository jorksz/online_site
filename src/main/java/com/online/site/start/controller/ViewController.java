package com.online.site.start.controller;

import com.online.site.start.entity.User;
import com.online.site.start.service.RoleService;
import com.online.site.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * 单独将所有跳转视图的controller抽离整合到一块
 */
@Controller
public class ViewController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("home/index/{id}")
    public String index(@PathVariable Integer id, Model model){
        model.addAttribute("userId",id);
        return "/home/index";
    }

    @RequestMapping("/")
    public String login(){
        return "index";
    }

    @RequestMapping("login/register")
    public String register(Model model){
        return "/login/register";
    }
}
