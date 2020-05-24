package com.online.site.start.controller;

import com.online.site.start.entity.PostDetail;
import com.online.site.start.service.PostDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discuss")
public class PostDetailController {
    @Autowired
    private PostDetailService postDetailService;

    @RequestMapping("/save")
    public boolean savePostDiscuss(PostDetail postDetail){
        return postDetailService.savePostDetail(postDetail);
    }
}
