package com.online.site.start.service.impl;

import com.github.pagehelper.Page;
import com.online.site.start.entity.PostDetail;
import com.online.site.start.mapper.PostDetailMapper;
import com.online.site.start.service.PostDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDetailServiceImpl implements PostDetailService {

    @Autowired
    private PostDetailMapper postDetailMapper;

    @Override
    public Page<PostDetail> ListPostDetail(Integer postId) {
        return postDetailMapper.ListPostDetail(postId);
    }

    @Override
    public Boolean savePostDetail(PostDetail postDetail) {
        return postDetailMapper.savePostDetail(postDetail) > 0;
    }
}
