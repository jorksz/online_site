package com.online.site.start.vo;

public class VideoCommentUserVO {
    private Integer videoCommentId;
    private Integer videoId;
    private String videoName;
    private String videoCommentContent;
    private String videoCommentTime;
    private String userName;
    private String userPicture;

    public Integer getVideoCommentId() {
        return videoCommentId;
    }

    public void setVideoCommentId(Integer videoCommentId) {
        this.videoCommentId = videoCommentId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoCommentContent() {
        return videoCommentContent;
    }

    public void setVideoCommentContent(String videoCommentContent) {
        this.videoCommentContent = videoCommentContent;
    }

    public String getVideoCommentTime() {
        return videoCommentTime;
    }

    public void setVideoCommentTime(String videoCommentTime) {
        this.videoCommentTime = videoCommentTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }
}
