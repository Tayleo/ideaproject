package com.example.demo.bean;

import java.util.Date;

/**
 * 小程序查询消息返回数据类型
 */
public class msgInfo {
    private int id;  //发送人的id
    private String message;
    private int type;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
