package com.online.site.start.entity;

public class PostReply {

    private Integer id;
    private Integer potId;
    private Integer dicussId;
    private Integer replyId;
    private String replyContent;
    private String replyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPotId() {
        return potId;
    }

    public void setPotId(Integer potId) {
        this.potId = potId;
    }

    public Integer getDicussId() {
        return dicussId;
    }

    public void setDicussId(Integer dicussId) {
        this.dicussId = dicussId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }
}
