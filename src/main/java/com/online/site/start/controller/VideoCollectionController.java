package com.online.site.start.controller;

import com.online.site.start.entity.VideoCollection;
import com.online.site.start.entity.VideoComment;
import com.online.site.start.mapper.VideoCollectionMapper;
import com.online.site.start.service.VideoCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vcn")
public class VideoCollectionController {

    @Autowired
    private VideoCollectionService videoCollectionService;
    @Autowired
    private VideoCollectionMapper videoCollectionMapper;

    @RequestMapping("/{userId}")
    public List<VideoCollection> listVideoCollection(@PathVariable Integer userId){
        return videoCollectionService.listVideoCollection(userId);
    }

    @RequestMapping("/count/{videoId}")
    public Integer countVideoCollection(@PathVariable Integer videoId){
        return videoCollectionMapper.countVideoCollection(videoId);
    }

    @RequestMapping("/save")
    public boolean save(VideoCollection videoCollection){
        return videoCollectionService.saveVideoCollection(videoCollection);
    }
}
