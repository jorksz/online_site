package com.online.site.start.service;

import com.github.pagehelper.Page;
import com.online.site.start.entity.Post;

public interface PostService {

    /**
     * 查询帖子
     * @param status 状态
     * @return
     */
    Page<Post> listPost(Integer status);

    /**
     * 查询帖子详细信息
     * @param id
     * @return
     */
    Post listPostOne(Integer id);

    /**
     * 删除帖子
     * @param id
     * @return
     */
    Boolean deletePost(Integer id);

    /**
     * 保存帖子
     * @param post
     * @return
     */
    Boolean savePost(Post post);

    /**
     * 修改帖子状态
     * @param post
     * @return
     */
    Boolean updatePost(Post post);
}
