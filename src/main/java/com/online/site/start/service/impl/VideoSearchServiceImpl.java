package com.online.site.start.service.impl;

import com.github.pagehelper.Page;
import com.online.site.start.mapper.VideoCollectionTypeVOMapper;
import com.online.site.start.service.VideoSearchService;
import com.online.site.start.vo.VideoCollectionTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoSearchServiceImpl implements VideoSearchService {

    @Autowired
    private VideoCollectionTypeVOMapper videoCollectionTypeVOMapper;

    @Override
    public Page<VideoCollectionTypeVO> listVideoCollectionTypeVO(String param) {
        String videoType = param;
        Page<VideoCollectionTypeVO> page = videoCollectionTypeVOMapper.listVideoCollectionTypeVOByType(videoType);
        if (page.size() == 0){
            String videoName = param;
            page = videoCollectionTypeVOMapper.listVideoCollectionTypeVOByVideoName(videoName);
            if (page.size() == 0){
                String videoLabel = param;
                page = videoCollectionTypeVOMapper.listVideoCollectionTypeVOByLabel(videoLabel);
            }
        }
        return page;
    }
}
