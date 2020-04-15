package com.online.site.start.service;

import com.online.site.start.entity.VideoCollection;

import java.util.List;

public interface VideoCollectionService {

    /**
     * 查询视频收藏
     * @param userId 用户id
     * @return
     */
    List<VideoCollection> listVideoCollection(Integer userId);

    /**
     * 保存收藏信息
     * @param videoCollection
     * @return
     */
    boolean saveVideoCollection(VideoCollection videoCollection);
}
