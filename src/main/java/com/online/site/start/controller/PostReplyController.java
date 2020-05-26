package com.online.site.start.controller;

import com.github.pagehelper.Page;
import com.online.site.start.entity.PostReply;
import com.online.site.start.entity.VideoCollection;
import com.online.site.start.mapper.PostDiscussUserVOMapper;
import com.online.site.start.service.PostReplyService;
import com.online.site.start.service.VideoCollectionService;
import com.online.site.start.vo.PostDiscussUserVO;
import com.online.site.start.vo.PostReplyUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reply")
public class PostReplyController {
    @Autowired
    private PostReplyService postReplyService;

    @Autowired
    private PostDiscussUserVOMapper discussUserVOMapper;

    @RequestMapping("/save")
    public boolean savePostReply(PostReply postReply){
        return postReplyService.savePostReply(postReply);
    }

    @RequestMapping("/test")
    public Map<Integer,List<PostReplyUserVO>> test(){
        Page<PostDiscussUserVO> postDiscussUserVOPage = discussUserVOMapper.ListPostDiscussUserVO(1);
        return postReplyService.ListPostReply(postDiscussUserVOPage);
    }
}
