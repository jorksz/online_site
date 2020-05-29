package com.online.site.start.controller;

import com.online.site.start.entity.Post;
import com.online.site.start.entity.User;
import com.online.site.start.sensitfilter.TabooedTools;
import com.online.site.start.sensitfilter.TabooedUtils;
import com.online.site.start.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/save")
    public boolean savePost(Post post){
        String content = post.getContent();
        if (TabooedUtils.isTabooed(content)){
            return false;
        }else {
            return postService.savePost(post);
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public boolean deletePost(@PathVariable Integer id){
        return postService.deletePost(id);
    }

    @RequestMapping(value = "/update")
    public boolean updatePost(Post post){
        return postService.updatePost(post);
    }

}
