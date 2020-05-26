package com.online.site.start.service;

import com.github.pagehelper.Page;
import com.online.site.start.entity.PostReply;
import com.online.site.start.vo.PostDiscussUserVO;
import com.online.site.start.vo.PostReplyUserVO;

import java.util.List;
import java.util.Map;

public interface PostReplyService {

    Map<Integer, List<PostReplyUserVO>> ListPostReply(Page<PostDiscussUserVO> postDiscussUserVOPage);

    /**
     * 保存回复
     * @param postReply
     * @return
     */
    Boolean savePostReply(PostReply postReply);
}
