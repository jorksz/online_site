package com.online.site.start.vo;

public class VideoCollectionTypeVO {
    private Integer videoId;
    private String videoName;
    private String videoLocation;
    private String videoIntroduction;
    private String videoPicture;
    private String videoUploadTime;
    private String uploadUser;
    private String videoType;
    private String videoLabel;
    private Integer collectionUserId;
    private Integer videoCollectionId;
    private String videoCollectionTime;

    public Integer getVideoCollectionId() {
        return videoCollectionId;
    }

    public void setVideoCollectionId(Integer videoCollectionId) {
        this.videoCollectionId = videoCollectionId;
    }

    public Integer getCollectionUserId() {
        return collectionUserId;
    }

    public void setCollectionUserId(Integer collectionUserId) {
        this.collectionUserId = collectionUserId;
    }


    public String getVideoLabel() {
        return videoLabel;
    }

    public void setVideoLabel(String videoLabel) {
        this.videoLabel = videoLabel;
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

    public String getVideoLocation() {
        return videoLocation;
    }

    public void setVideoLocation(String videoLocation) {
        this.videoLocation = videoLocation;
    }

    public String getVideoIntroduction() {
        return videoIntroduction;
    }

    public void setVideoIntroduction(String videoIntroduction) {
        this.videoIntroduction = videoIntroduction;
    }

    public String getVideoPicture() {
        return videoPicture;
    }

    public void setVideoPicture(String videoPicture) {
        this.videoPicture = videoPicture;
    }

    public String getVideoUploadTime() {
        return videoUploadTime;
    }

    public void setVideoUploadTime(String videoUploadTime) {
        this.videoUploadTime = videoUploadTime;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoCollectionTime() {
        return videoCollectionTime;
    }

    public void setVideoCollectionTime(String videoCollectionTime) {
        this.videoCollectionTime = videoCollectionTime;
    }
}
