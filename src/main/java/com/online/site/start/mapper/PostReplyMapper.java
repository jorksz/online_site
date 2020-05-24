package com.online.site.start.mapper;

import com.online.site.start.entity.PostDetail;
import com.online.site.start.entity.PostReply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostReplyMapper {
    /**
     * 获取帖子回复信息
     * @param postId 帖子ID
     * @param discussId 评论内容ID
     * @return
     */
    List<PostReply> ListPostReply(Integer postId, Integer discussId);

    /**
     * 保存回复
     * @param postReply
     * @return
     */
    Integer savePostReply(PostReply postReply);
}
