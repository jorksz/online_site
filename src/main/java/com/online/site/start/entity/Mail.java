package com.online.site.start.entity;

import java.util.Date;

/**
 * 记录每次发送邮件信息
 */
public class Mail {
    private Integer id;
    private String title;
    private String content;
    private Integer toMailNumber;
    private Date startTime;
    private Date endTime;
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

    public Integer getToMailNumber() {
        return toMailNumber;
    }

    public void setToMailNumber(Integer toMailNumber) {
        this.toMailNumber = toMailNumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
