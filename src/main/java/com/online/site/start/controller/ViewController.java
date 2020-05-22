package com.online.site.start.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.online.site.start.entity.User;
import com.online.site.start.service.RoleService;
import com.online.site.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * 单独将所有跳转视图的controller抽离整合到一块
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    private UserController userController;

    @RequestMapping("home/index/{id}")
    public String index(@PathVariable Integer id, Model model){
        model.addAttribute("userId",id);
        return "/home/index";
    }

    @RequestMapping("")
    public String login(){
        return "index";
    }

    @RequestMapping("login/register")
    public String register(Model model){
        return "/login/register";
    }


    @RequestMapping("bg/user")
    public String bgUser(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "5") int pageSize, Model model){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userService.listUser());
        model.addAttribute("userList", pageInfo);
        return "/background/user_manage";
    }

    @RequestMapping("bg/video")
    public String bgVideo(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "6") int pageSize, Model model){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userService.listUser());
        model.addAttribute("userList", pageInfo);
        return "/background/video_manage";
    }

    @RequestMapping("bg/post")
    public String bgPost(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "3") int pageSize, Model model){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userService.listUser());
        model.addAttribute("userList", pageInfo);
        return "/background/post_manage";
    }
}
