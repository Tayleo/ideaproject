package com.example.demo.config;

import org.apache.shiro.authc.AuthenticationToken;

public class wechatToken implements AuthenticationToken {
    private String openId;
    private String sessionKey;
    public wechatToken(String openId,String sessionKey){
        this.openId=openId;
        this.sessionKey=sessionKey;
    }
    public String getOpenId(){
        return openId;
    }
    public String getSessionKey(){
        return sessionKey;
    }
    @Override
    public Object getPrincipal() {
        return openId;
    }
    @Override
    public Object getCredentials() {
        return openId;
    }
}
