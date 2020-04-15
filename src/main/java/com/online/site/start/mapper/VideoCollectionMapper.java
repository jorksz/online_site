package com.online.site.start.mapper;

import com.online.site.start.entity.History;
import com.online.site.start.entity.VideoCollection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoCollectionMapper {

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
    Integer saveVideoCollection(VideoCollection videoCollection);
}
