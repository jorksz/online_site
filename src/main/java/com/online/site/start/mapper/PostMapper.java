package com.online.site.start.mapper;

import com.github.pagehelper.Page;
import com.online.site.start.entity.Post;
import com.online.site.start.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    /**
     * 查询帖子
     * @param status 状态
     * @return
     */
    Page<Post> listPost(Integer status);

    /**
     * 删除帖子
     * @param id
     * @return
     */
    Integer deletePost(Integer id);

    /**
     * 保存帖子
     * @param post
     * @return
     */
    Integer savePost(Post post);

    /**
     * 修改帖子状态
     * @param post
     * @return
     */
    Integer updatePost(Post post);
}
