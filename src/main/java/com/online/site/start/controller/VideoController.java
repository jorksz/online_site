package com.online.site.start.controller;

import com.online.site.start.entity.User;
import com.online.site.start.entity.Video;
import com.online.site.start.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/delete/{id}")
    public boolean deleteVideo(@PathVariable Integer id){
        return videoService.deleteVideo(id);
    }

    @RequestMapping("/update")
    public boolean passVideo(Video video){
        return videoService.updateVideo(video);
    }

    @RequestMapping("/find")
    public List<Video> listVideos(String videoName){
        return videoService.listVideos(videoName, 1);
    }

    @RequestMapping("/findT/{typeName}")
    public List<Video> listVideosT(@PathVariable String typeName){
        return videoService.listVideosByType(typeName, 1);
    }

    @RequestMapping("/findO/{id}/{isPass}")
    public Video getVideo(@PathVariable Integer id, @PathVariable Integer isPass){
        return videoService.getVideo(id, isPass);
    }

    @RequestMapping("/upload")
    public boolean uploadVideo(@ModelAttribute("currentUser") User user, MultipartFile file, Video video){
        if (file.isEmpty()) {
            return false;
        }
        String fileName = file.getOriginalFilename();
        String filePath = "/video";
        video.setUserId(user.getId());
        video.setUserName(user.getUserName());
        video.setVideoLocation(filePath);
        video.setVideoName(fileName);
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            videoService.uploadVideo(video);
            return true;
        } catch (IOException e) { }
        return false;
    }


}
