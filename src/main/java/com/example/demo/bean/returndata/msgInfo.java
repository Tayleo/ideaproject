package com.example.demo.bean.returndata;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 小程序查询消息返回数据类型
 */
public class msgInfo {
    private int info_id;
    private int real_send_id;  //发送人的id
    private String info_content;
    private int status;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date info_time;
    private Byte msgtype;

    public Byte getType() {
        return msgtype;
    }

    public void setType(Byte type) {
        this.msgtype = type;
    }

    public int getInfo_id() {
        return info_id;
    }

    public void setInfo_id(int info_id) {
        this.info_id = info_id;
    }

    public Byte getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(Byte msgtype) {
        this.msgtype = msgtype;
    }

    public int getReal_send_id() {
        return real_send_id;
    }

    public void setReal_send_id(int real_send_id) {
        this.real_send_id = real_send_id;
    }

    public String getInfo_content() {
        return info_content;
    }

    public void setInfo_content(String info_content) {
        this.info_content = info_content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getInfo_time() {
        return info_time;
    }

    public void setInfo_time(Date info_time) {
        this.info_time = info_time;
    }
}
