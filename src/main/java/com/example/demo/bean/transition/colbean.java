package com.example.demo.bean.transition;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class colbean {
    private int user_id;
    private int user_role;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date col_time;

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
}
