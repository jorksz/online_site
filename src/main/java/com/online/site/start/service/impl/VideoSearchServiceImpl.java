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
        //视频类型查询，参数重新赋值
        String videoType = param;
        Page<VideoCollectionTypeVO> page = videoCollectionTypeVOMapper.listVideoCollectionTypeVOByType(videoType);
        //如果为空，则使用视频名查询
        if (page.size() == 0){
            String videoName = param;
            page = videoCollectionTypeVOMapper.listVideoCollectionTypeVOByVideoName(videoName);
            //如果视频名查询为空，则调用视频标签查询
            if (page.size() == 0){
                String videoLabel = param;
                page = videoCollectionTypeVOMapper.listVideoCollectionTypeVOByLabel(videoLabel);
            }
        }
        //如果3者都为空，则返回空集合
        return page;
    }
}
