package com.example.demo.bean.returndata;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class starinfo {
    private int user_id;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private int user_role;
    private Date col_time;
    private String name;
    private String avatar;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date bitrhday;
    private String details;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_role() {
        return user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

    public Date getCol_time() {
        return col_time;
    }

    public void setCol_time(Date col_time) {
        this.col_time = col_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBitrhday() {
        return bitrhday;
    }

    public void setBitrhday(Date bitrhday) {
        this.bitrhday = bitrhday;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
