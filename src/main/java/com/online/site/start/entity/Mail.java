package com.online.site.start.entity;

import java.util.Date;

/**
 * 记录每次发送邮件信息
 */
public class Mail {
    private Integer id;
    private String title;
    private String content;
    private String toMailNumber;
    private String startTime;
    private String endTime;
    private String verificationCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToMailNumber() {
        return toMailNumber;
    }

    public void setToMailNumber(String toMailNumber) {
        this.toMailNumber = toMailNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
