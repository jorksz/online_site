package com.online.site.start.service;

import com.github.pagehelper.Page;
import com.online.site.start.entity.PostDetail;

public interface PostDetailService {
    /**
     * 获取帖子评论信息
     * @param postId
     * @return
     */
    Page<PostDetail> ListPostDetail(Integer postId);

    /**
     * 保存评论
     * @param postDetail
     * @return
     */
    Boolean savePostDetail(PostDetail postDetail);
}
