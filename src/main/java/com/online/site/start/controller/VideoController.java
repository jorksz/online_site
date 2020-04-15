package com.online.site.start.controller;

import com.online.site.start.entity.Video;
import com.online.site.start.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/{id}")
    public boolean deleteVideo(@PathVariable Integer id){
        return videoService.deleteVideo(id);
    }

    @RequestMapping("/{id}/{isPass}")
    public boolean passVideo(@PathVariable Integer id, @PathVariable Integer isPass){
        return videoService.updateVideo(id, isPass);
    }

    @RequestMapping("/find")
    public List<Video> listVideos(String videoName){
        return videoService.listVideos(videoName, 1);
    }

    @RequestMapping("/findT/{typeName}")
    public List<Video> listVideosT(@PathVariable String typeName){
        return videoService.listVideosByType(typeName, 1);
    }

    @RequestMapping("/allU")
    public List<Video> listAllForUser(){
        return videoService.listAll(1);
    }

    @RequestMapping("/allM")
    public List<Video> listAllForM(){
        return videoService.listAllM();
    }

    @RequestMapping("/findO/{id}/{isPass}")
    public List<Video> getVideo(@PathVariable Integer id, @PathVariable Integer isPass){
        return videoService.getVideo(id, isPass);
    }

    @RequestMapping("/save")
    public boolean uploadVideo(Video video){
        return videoService.uploadVideo(video);
    }


}
