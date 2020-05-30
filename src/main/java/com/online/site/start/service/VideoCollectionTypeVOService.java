package com.online.site.start.service;

import com.github.pagehelper.Page;
import com.online.site.start.vo.VideoCollectionTypeVO;

public interface VideoCollectionTypeVOService {

    /**
     * 根据视频类型查询视频相关信息
     * @param videoType 视频类型
     * @return
     */
    Page<VideoCollectionTypeVO> listVideoCollectionTypeVOByType(String videoType);

    /**
     * 根据视频标签查询视频相关信息
     * @param videoLabel 视频标签
     * @return
     */
    Page<VideoCollectionTypeVO> listVideoCollectionTypeVOByLabel(String videoLabel);

    /**
     * 根据查询视频相关信息
     * @param videoName
     * @return
     */
    Page<VideoCollectionTypeVO> listVideoCollectionTypeVOByVideoName(String videoName);

    /**
     * 根据视频名关键字查询视频相关信息
     * @param videoName
     * @return
     */
    Page<VideoCollectionTypeVO> listVideoCollectionTypeVOByVideoKeyName(String videoName);
}
