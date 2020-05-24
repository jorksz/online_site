package com.online.site.start.mapper;

import com.github.pagehelper.Page;
import com.online.site.start.entity.PostDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostDetailMapper {

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
    Integer savePostDetail(PostDetail postDetail);
}
