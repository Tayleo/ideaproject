package com.example.demo.bean;

public class info_status {
    private Integer infoStatusId;

    private String infoStatus;

    public Integer getInfoStatusId() {
        return infoStatusId;
    }

    public void setInfoStatusId(Integer infoStatusId) {
        this.infoStatusId = infoStatusId;
    }

    public String getInfoStatus() {
        return infoStatus;
    }

    public void setInfoStatus(String infoStatus) {
        this.infoStatus = infoStatus == null ? null : infoStatus.trim();
    }
}