package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class col {


    private Integer userId;

    private Integer userColId;

    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date colTime;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserColId() {
        return userColId;
    }

    public void setUserColId(Integer userColId) {
        this.userColId = userColId;
    }

    public Date getColTime() {
        return colTime;
    }

    public void setColTime(Date colTime) {
        this.colTime = colTime;
    }
}