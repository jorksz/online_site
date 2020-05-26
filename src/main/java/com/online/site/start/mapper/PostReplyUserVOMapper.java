package com.online.site.start.mapper;

import com.github.pagehelper.Page;
import com.online.site.start.entity.PostReply;
import com.online.site.start.vo.PostDiscussUserVO;
import com.online.site.start.vo.PostReplyUserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostReplyUserVOMapper {
    /**
     * 获取该评论下回复信息
     * @param postId 帖子ID
     * @param discussId 评论ID
     * @return
     */
    List<PostReplyUserVO> ListPostReplyUserVO(Integer postId, Integer discussId);
}
