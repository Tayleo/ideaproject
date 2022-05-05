package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class relative {
    private Integer userId;

    private String childrenName;

    private Byte childrenGender;

    private Integer childrenAge;

    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date birthday;

    private String phone;

    private String eMail;

    private String lostCloth;

    private String lostHeight;

    private String lostAddress;

    private String lostTime;

    private String features;

    private String details;

    private String relation;

    private String childrenUrl;

    private Integer isRelease;

    private Date releaseTime;

    public Integer getIsRelease() {
        return isRelease;
    }

    public void setIsRelease(Integer isRelease) {
        this.isRelease = isRelease;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getChildrenName() {
        return childrenName;
    }

    public void setChildrenName(String childrenName) {
        this.childrenName = childrenName == null ? null : childrenName.trim();
    }

    public Byte getChildrenGender() {
        return childrenGender;
    }

    public void setChildrenGender(Byte childrenGender) {
        this.childrenGender = childrenGender;
    }

    public Integer getChildrenAge() {
        return childrenAge;
    }

    public void setChildrenAge(Integer childrenAge) {
        this.childrenAge = childrenAge;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public String getLostCloth() {
        return lostCloth;
    }

    public void setLostCloth(String lostCloth) {
        this.lostCloth = lostCloth == null ? null : lostCloth.trim();
    }

    public String getLostHeight() {
        return lostHeight;
    }

    public void setLostHeight(String lostHeight) {
        this.lostHeight = lostHeight == null ? null : lostHeight.trim();
    }

    public String getLostAddress() {
        return lostAddress;
    }

    public void setLostAddress(String lostAddress) {
        this.lostAddress = lostAddress == null ? null : lostAddress.trim();
    }

    public String getLostTime() {
        return lostTime;
    }

    public void setLostTime(String lostTime) {
        this.lostTime = lostTime;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features == null ? null : features.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public String getChildrenUrl() {
        return childrenUrl;
    }

    public void setChildrenUrl(String childrenUrl) {
        this.childrenUrl = childrenUrl == null ? null : childrenUrl.trim();
    }
}