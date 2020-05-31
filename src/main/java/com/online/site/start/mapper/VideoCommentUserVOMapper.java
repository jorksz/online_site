package com.online.site.start.mapper;

import com.github.pagehelper.Page;
import com.online.site.start.vo.VideoCommentUserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoCommentUserVOMapper {

    /**
     * 获取视频评论信息
     * @param videoId
     * @return
     */
    Page<VideoCommentUserVO> listVideoCommentUserVO(Integer videoId);
}
