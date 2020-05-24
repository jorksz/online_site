package com.online.site.start.entity;

/**
 * 帖子详细信息
 */
public class PostDetail {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }

    public String getDiscussTime() {
        return discussTime;
    }

    public void setDiscussTime(String discussTime) {
        this.discussTime = discussTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    private Integer id;
    private String postName;
    private Integer postId;
    private Integer discussId;

    public String getDiscussName() {
        return discussName;
    }

    public void setDiscussName(String discussName) {
        this.discussName = discussName;
    }

    private String discussName;
    private String discussTime;
    private String content;
}
