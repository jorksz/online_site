package com.online.site.start.service.impl;

import com.online.site.start.entity.VideoComment;
import com.online.site.start.mapper.VideoCommentMapper;
import com.online.site.start.service.VideoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoCommentServiceImpl implements VideoCommentService {

    @Autowired
    private VideoCommentMapper videoCommentMapper;

    @Override
    public List<VideoComment> listVideoComment(Integer userId) {
        return videoCommentMapper.listVideoComment(userId);
    }

    @Override
    public boolean saveVideoComment(VideoComment videoComment) {
        return videoCommentMapper.saveVideoComment(videoComment) > 0;
    }
}
