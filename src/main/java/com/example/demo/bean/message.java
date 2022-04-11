package com.example.demo.bean;

import java.util.Date;

public class message {
    private Integer infoId;

    private Integer sendId;

    private Integer acceptId;

    private Integer realSendId;

    private Integer realAcceptId;

    private String infoContent;

    private Date infoTime;

    private Byte status;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(Integer acceptId) {
        this.acceptId = acceptId;
    }

    public Integer getRealSendId() {
        return realSendId;
    }

    public void setRealSendId(Integer realSendId) {
        this.realSendId = realSendId;
    }

    public Integer getRealAcceptId() {
        return realAcceptId;
    }

    public void setRealAcceptId(Integer realAcceptId) {
        this.realAcceptId = realAcceptId;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent == null ? null : infoContent.trim();
    }

    public Date getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Date infoTime) {
        this.infoTime = infoTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}