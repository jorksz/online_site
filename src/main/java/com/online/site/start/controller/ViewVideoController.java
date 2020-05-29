package com.online.site.start.controller;

import com.online.site.start.service.VideoSearchService;
import com.online.site.start.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
