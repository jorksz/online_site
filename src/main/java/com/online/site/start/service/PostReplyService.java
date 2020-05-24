package com.online.site.start.service;

import com.online.site.start.entity.PostReply;

import java.util.List;

public interface PostReplyService {
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
    Boolean savePostReply(PostReply postReply);
}
