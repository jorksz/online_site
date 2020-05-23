package com.online.site.start.service.impl;

import com.github.pagehelper.Page;
import com.online.site.start.entity.Video;
import com.online.site.start.mapper.VideoMapper;
import com.online.site.start.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideos(String videoName, Integer isPass) {
        return videoMapper.listVideos(videoName, isPass);
    }

    @Override
    public List<Video> listVideosByType(String typeName, Integer isPass) {
        return videoMapper.listVideosByType(typeName, isPass);
    }

    @Override
    public List<Video> getVideo(Integer id, Integer isPass) {
        return videoMapper.getVideo(id, isPass);
    }

    @Override
    public Page<Video> listAll(Integer isPass) {
        return videoMapper.listAll(isPass);
    }


    @Override
    public boolean deleteVideo(Integer id) {
        return videoMapper.deleteVideo(id) > 0;
    }

    @Override
    public boolean updateVideo(Video video) {
        return videoMapper.updateVideo(video) > 0;
    }

    @Override
    public boolean uploadVideo(Video video) {
        return videoMapper.saveVideo(video) > 0;
    }
}
