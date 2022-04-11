package com.example.demo.bean;

import java.util.Date;

public class col {
    private Integer colId;

    private Integer userId;

    private Integer userColId;

    private Date colTime;

    public Integer getColId() {
        return colId;
    }

    public void setColId(Integer colId) {
        this.colId = colId;
    }

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