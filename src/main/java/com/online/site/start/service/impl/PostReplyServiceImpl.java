package com.online.site.start.service.impl;

import com.online.site.start.entity.PostReply;
import com.online.site.start.mapper.PostReplyMapper;
import com.online.site.start.service.PostReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostReplyServiceImpl implements PostReplyService {

    @Autowired
    private PostReplyMapper postReplyMapper;

    @Override
    public List<PostReply> ListPostReply(Integer postId, Integer discussId) {
        return postReplyMapper.ListPostReply(postId, discussId);
    }

    @Override
    public Boolean savePostReply(PostReply postReply) {
        return postReplyMapper.savePostReply(postReply) > 0;
    }
}
