package com.online.site.start.controller;

import com.github.pagehelper.Page;
import com.online.site.start.entity.PostDetail;
import com.online.site.start.mapper.PostDiscussUserVOMapper;
import com.online.site.start.service.PostDetailService;
import com.online.site.start.vo.PostDiscussUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discuss")
public class PostDetailController {
    @Autowired
    private PostDetailService postDetailService;
    @Autowired
    private PostDiscussUserVOMapper postDiscussUserVO;

    @RequestMapping("/save")
    public boolean savePostDiscuss(PostDetail postDetail){
        return postDetailService.savePostDetail(postDetail);
    }

    @RequestMapping("/test")
    public Page<PostDiscussUserVO> list(){
        return postDiscussUserVO.ListPostDiscussUserVO(1);
    }
}
