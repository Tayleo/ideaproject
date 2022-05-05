package com.example.demo.service;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.result.Result;

import java.util.Map;

public interface MessageService {
    Result getallmessage(int user_id);
    Result getMessageBefore(int user_id,int another_id,int page,int pagesize);
    Result sendMessage(Map<String,Object> params);
    Result insertDB(JSONObject jsonObject);
}
