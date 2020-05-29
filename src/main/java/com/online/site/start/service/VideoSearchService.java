package com.online.site.start.service;

import com.github.pagehelper.Page;
import com.online.site.start.vo.VideoCollectionTypeVO;

public interface VideoSearchService {

    /**
     * 在线搜索
     * @param param 参数，可为视频名、视频标签、视频类型
     * @return
     */
    Page<VideoCollectionTypeVO> listVideoCollectionTypeVO(String param);
}
