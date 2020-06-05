package com.online.site.start.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.online.site.start.entity.Message;
import com.online.site.start.entity.User;
import com.online.site.start.service.MessageService;
import com.online.site.start.service.VideoCollectionTypeVOService;
import com.online.site.start.vo.VideoCollectionTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewUserController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private VideoCollectionTypeVOService videoCollectionTypeVOService;

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
        List<Message> messageList = messageService.listMessage(user.getId());
        model.addAttribute("messageList",messageList);

        return "/user/message";
    }

    @RequestMapping("/user/history")
    public String history(Model model, HttpSession session, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        Integer userId = user.getId();
        PageHelper.startPage(pageNo,pageSize);
        Page<VideoCollectionTypeVO> page = videoCollectionTypeVOService.listVideoHistory(userId);
        PageInfo<VideoCollectionTypeVO> pageInfo = new PageInfo<>(page);
        model.addAttribute("historyList",pageInfo);
        return "/user/history";
    }

    @RequestMapping("/user/collection")
    public String collection(Model model, HttpSession session, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        Integer userId = user.getId();
        PageHelper.startPage(pageNo,pageSize);
        Page<VideoCollectionTypeVO> page = videoCollectionTypeVOService.listVideoConllection(userId);
        PageInfo<VideoCollectionTypeVO> pageInfo = new PageInfo<>(page);
        model.addAttribute("collectionList",pageInfo);
        return "/user/collection";
    }


}
