package com.online.site.start.entity;

public class History {

    private Integer historyId;
    private Integer userId;
    private Integer videoId;
    private String startTime;

    public Integer getId() {
        return historyId;
    }

    public void setId(Integer historyId) {
        this.historyId = historyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


}
