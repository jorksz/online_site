package com.online.site.start.service.impl;

import com.online.site.start.entity.VideoCollection;
import com.online.site.start.mapper.VideoCollectionMapper;
import com.online.site.start.service.VideoCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoCollectionServiceImpl implements VideoCollectionService {

    @Autowired
    private VideoCollectionMapper videoCollectionMapper;

    @Override
    public List<VideoCollection> listVideoCollection(Integer userId) {
        return videoCollectionMapper.listVideoCollection(userId);
    }

    @Override
    public boolean saveVideoCollection(VideoCollection videoCollection) {
        return videoCollectionMapper.saveVideoCollection(videoCollection) > 0;
    }

    @Override
    public boolean deleteCollection(Integer collectionId) {
        return videoCollectionMapper.deleteCollection(collectionId) > 0;
    }
}
