package com.online.site.start.mapper;

import com.online.site.start.entity.VideoComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoCommentMapper {

    /**
     * 查询视频收藏
     * @param userId 用户id
     * @return
     */
    List<VideoComment> listVideoComment(Integer userId);

    /**
     * 查询视频收藏
     * @param videoId 视频iD
     * @return
     */
    List<VideoComment> listVideoCommentByVideoID(Integer videoId);

    /**
     * 保存收藏信息
     * @param videoComment
     * @return
     */
    Integer saveVideoComment(VideoComment videoComment);
}
