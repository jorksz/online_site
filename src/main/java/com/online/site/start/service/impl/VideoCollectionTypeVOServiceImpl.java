package com.online.site.start.service.impl;

import com.github.pagehelper.Page;
import com.online.site.start.mapper.VideoCollectionTypeVOMapper;
import com.online.site.start.service.VideoCollectionTypeVOService;
import com.online.site.start.vo.VideoCollectionTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoCollectionTypeVOServiceImpl implements VideoCollectionTypeVOService {

    @Autowired
    private VideoCollectionTypeVOMapper videoCollectionTypeVOMapper;

    @Override
    public Page<VideoCollectionTypeVO> listVideoCollectionTypeVOByType(String videoType) {
        return videoCollectionTypeVOMapper.listVideoCollectionTypeVOByType(videoType);
    }

    @Override
    public Page<VideoCollectionTypeVO> listVideoCollectionTypeVOByLabel(String videoLabel) {
        return videoCollectionTypeVOMapper.listVideoCollectionTypeVOByLabel(videoLabel);
    }

    @Override
    public Page<VideoCollectionTypeVO> listVideoCollectionTypeVOByVideoName(String videoName) {
        return videoCollectionTypeVOMapper.listVideoCollectionTypeVOByVideoName(videoName);
    }

    @Override
    public Page<VideoCollectionTypeVO> listVideoCollectionTypeVOByVideoKeyName(String videoName) {
        return videoCollectionTypeVOMapper.listVideoCollectionTypeVOByVideoKeyName(videoName);
    }

    @Override
    public Page<VideoCollectionTypeVO> listVideoConllection(Integer userId) {
        return videoCollectionTypeVOMapper.listVideoConllection(userId);
    }

    @Override
    public Page<VideoCollectionTypeVO> listVideoHistory(Integer historyUserId) {
        return videoCollectionTypeVOMapper.listVideoHistory(historyUserId);
    }
}
