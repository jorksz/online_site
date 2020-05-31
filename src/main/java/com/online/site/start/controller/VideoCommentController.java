package com.online.site.start.controller;

import com.online.site.start.entity.History;
import com.online.site.start.entity.VideoComment;
import com.online.site.start.service.VideoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vct")
public class VideoCommentController {

    @Autowired
    private VideoCommentService videoCommentService;

    @RequestMapping("/{userId}")
    public List<VideoComment> listVideoComment(@PathVariable Integer userId){
        return videoCommentService.listVideoComment(userId);
    }

    @RequestMapping("/save")
    public boolean saveComment(VideoComment videoComment){
        return videoCommentService.saveVideoComment(videoComment);
    }
}
