package com.online.site.start.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.online.site.start.entity.User;
import com.online.site.start.entity.Video;
import com.online.site.start.entity.VideoComment;
import com.online.site.start.service.VideoCommentService;
import com.online.site.start.service.VideoSearchService;
import com.online.site.start.service.VideoService;
import com.online.site.start.vo.VideoCollectionTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * 视图Video相关的前端控制器
 */
@Controller
@RequestMapping("/view")
public class ViewVideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoSearchService videoSearchService;

    @Autowired
    private VideoCommentService videoCommentService;


    @RequestMapping("/search/{param}")
    public String toSeachIndex(@PathVariable String param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize, Model model, HttpSession session){
        //获取user信息
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        Page<VideoCollectionTypeVO> page = videoSearchService.listVideoCollectionTypeVO(param);
        //转成分页Bean
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<VideoCollectionTypeVO> pageInfo = new PageInfo<>(page);
        model.addAttribute("pageInfo", pageInfo);
        return "search/search";
    }

    @RequestMapping("/video/play/{videoId}")
    public String toVideoPlayer(@PathVariable Integer videoId, Model model, HttpSession session){
        //获取user信息
        User user  = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        Video video = videoService.getVideo(videoId, 2);
        model.addAttribute("video", video);
       /* List<VideoComment> videoComments = videoCommentService.listVideoCommentByVideoID(videoId);
        model.addAttribute("listComments", videoComments);*/
        return "video/video";
    }
}
