package com.online.site.start.mapper;

import com.github.pagehelper.Page;
import com.online.site.start.entity.PostDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostDiscussUserVOMapper {
    /**
     * 获取帖子评论信息
     * @param postId
     * @return
     */
    Page<PostDetail> ListPostDiscussUserVO(Integer postId);
}
