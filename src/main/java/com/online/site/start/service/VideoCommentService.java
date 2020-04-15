package com.online.site.start.service;

import com.online.site.start.entity.VideoComment;

import java.util.List;

public interface VideoCommentService {

    /**
     * 查询视频收藏
     * @param userId 用户id
     * @return
     */
    List<VideoComment> listVideoComment(Integer userId);

    /**
     * 保存收藏信息
     * @param videoComment
     * @return
     */
    boolean saveVideoComment(VideoComment videoComment);
}
