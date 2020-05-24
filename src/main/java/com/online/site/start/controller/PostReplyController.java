package com.online.site.start.controller;

import com.online.site.start.entity.PostReply;
import com.online.site.start.entity.VideoCollection;
import com.online.site.start.service.PostReplyService;
import com.online.site.start.service.VideoCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class PostReplyController {
    @Autowired
    private PostReplyService postReplyService;


    @RequestMapping("/save")
    public boolean savePostReply(PostReply postReply){
        return postReplyService.savePostReply(postReply);
    }
}
