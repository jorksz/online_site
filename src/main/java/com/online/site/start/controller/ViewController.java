package com.online.site.start.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.online.site.start.entity.*;
import com.online.site.start.mapper.PostDiscussUserVOMapper;
import com.online.site.start.service.*;
import com.online.site.start.vo.PostDiscussUserVO;
import com.online.site.start.vo.PostReplyUserVO;
import com.online.site.start.vo.VideoCollectionTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private PostService postService;

    @Autowired
    private PostDetailService postDetailService;

    @Autowired
    private PostReplyService postReplyService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private PostDiscussUserVOMapper postDiscussUserVOMapper;
    @Autowired
    private VideoCollectionTypeVOService videoCollectionTypeVOService;

    @RequestMapping("home/index")
    public String index(Model model, HttpSession session,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<VideoCollectionTypeVO> bgPageInfo = new PageInfo<>(videoCollectionTypeVOService.listVideoCollectionTypeVOByLabel("后端"));
        model.addAttribute("bgPageInfo", bgPageInfo);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<VideoCollectionTypeVO> frontPageInfo = new PageInfo<>(videoCollectionTypeVOService.listVideoCollectionTypeVOByLabel("前端"));
        model.addAttribute("frontPageInfo", frontPageInfo);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<VideoCollectionTypeVO> movePageInfo = new PageInfo<>(videoCollectionTypeVOService.listVideoCollectionTypeVOByLabel("移动开发"));
        model.addAttribute("movePageInfo", movePageInfo);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<VideoCollectionTypeVO> computerPageInfo = new PageInfo<>(videoCollectionTypeVOService.listVideoCollectionTypeVOByLabel("计算机基础"));
        model.addAttribute("computerPageInfo", computerPageInfo);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<VideoCollectionTypeVO> dbPageInfo = new PageInfo<>(videoCollectionTypeVOService.listVideoCollectionTypeVOByLabel("数据库"));
        model.addAttribute("dbPageInfo", dbPageInfo);
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
    public String bgVideo(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "5") int pageSize, Model model){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Video> pageInfo = new PageInfo<>(videoService.listAll(2));
        model.addAttribute("videoList", pageInfo);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Video> pageInfo2 = new PageInfo<>(videoService.listAll(1));
        model.addAttribute("videoList2", pageInfo2);
        return "/background/video_manage";
    }

    @RequestMapping("bg/post")
    public String bgPost(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "5") int pageSize, Model model){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Post> pageInfo = new PageInfo<>(postService.listPost(2));
        model.addAttribute("postList", pageInfo);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Post> pageInfo2 = new PageInfo<>(postService.listPost(1));
        model.addAttribute("postList2", pageInfo2);
        return "/background/post_manage";
    }

    @RequestMapping("post/index")
    public String postIndex(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize, Model model, HttpSession session){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Post> pageInfo = new PageInfo<>(postService.listPost(2));
        model.addAttribute("postList", pageInfo);
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "/community/post";
    }

    @RequestMapping("post/write")
    public String writePost( Model model, HttpSession session){
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "/community/publish_post";
    }

    @RequestMapping("post/detail/{postId}")
    public String postDetail(@PathVariable Integer postId, Model model, HttpSession session,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "6") int pageSize){
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        model.addAttribute("postId",postId);
        Post post = postService.listPostOne(postId);
        model.addAttribute("post",post);
        Page<PostDiscussUserVO> postDiscussUserVOPage = postDiscussUserVOMapper.ListPostDiscussUserVO(postId);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<PostDiscussUserVO> pageInfoDetail = new PageInfo<>(postDiscussUserVOPage);
        model.addAttribute("pageInfoDetail",pageInfoDetail);
        Map<Integer, List<PostReplyUserVO>> replyMap = postReplyService.ListPostReply(postDiscussUserVOPage);
        model.addAttribute("replyMap",replyMap);
        return "/community/post_detail";
    }



}
