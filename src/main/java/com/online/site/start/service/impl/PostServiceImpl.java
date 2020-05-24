package com.online.site.start.service.impl;

import com.github.pagehelper.Page;
import com.online.site.start.entity.Post;
import com.online.site.start.mapper.PostMapper;
import com.online.site.start.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public Page<Post> listPost(Integer status) {
        return postMapper.listPost(status);
    }

    @Override
    public Post listPostOne(Integer id) {
        return postMapper.listPostOne(id);
    }

    @Override
    public Boolean deletePost(Integer id) {
        return postMapper.deletePost(id) > 0;
    }

    @Override
    public Boolean savePost(Post post) {
        return postMapper.savePost(post) > 0;
    }

    @Override
    public Boolean updatePost(Post post) {
        return postMapper.updatePost(post) > 0;
    }
}
