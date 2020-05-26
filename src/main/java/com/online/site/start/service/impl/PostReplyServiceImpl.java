package com.online.site.start.service.impl;

import com.github.pagehelper.Page;
import com.online.site.start.entity.PostReply;
import com.online.site.start.mapper.PostReplyMapper;
import com.online.site.start.mapper.PostReplyUserVOMapper;
import com.online.site.start.service.PostReplyService;
import com.online.site.start.vo.PostDiscussUserVO;
import com.online.site.start.vo.PostReplyUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostReplyServiceImpl implements PostReplyService {

    @Autowired
    private PostReplyUserVOMapper postReplyUserVOMapper;
    @Autowired
    private PostReplyMapper postReplyMapper;

    @Override
    public Map<Integer, List<PostReplyUserVO>> ListPostReply(Page<PostDiscussUserVO> postDiscussUserVOPage) {
        Map<Integer, List<PostReplyUserVO>> res = new HashMap<>();
        if (postDiscussUserVOPage.size() > 0){
            for (PostDiscussUserVO  postDiscussUserVO : postDiscussUserVOPage){
                Integer key = postDiscussUserVO.getPostId();
                Integer discussId = postDiscussUserVO.getDiscussId();
                List<PostReplyUserVO> value = postReplyUserVOMapper.ListPostReplyUserVO(key, discussId);
                res.put(discussId, value);
            }
        }
        return res;
    }

    @Override
    public Boolean savePostReply(PostReply postReply) {
        return postReplyMapper.savePostReply(postReply) > 0;
    }
}
