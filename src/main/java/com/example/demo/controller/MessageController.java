package com.example.demo.controller;

import com.example.demo.result.Result;
import com.example.demo.service.serviceImpl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/MessageController")
@CrossOrigin
public class MessageController {

    @Autowired
    MessageServiceImpl messageService;

    /**
     * 获取当前用户所有聊天记录
     * @return Result
     */
    @RequestMapping(value = "getallMessage")
    public Result getallMessage(@RequestBody Map<String, Integer> params){
        int user_id=params.get("user_id");
        return messageService.getallmessage(user_id);
    }

    /**
     * 获取当前用户消息列表，即只读取最近时间与不同人的聊天记录
     */
    @RequestMapping("/getRecentMessage")
    public Result getRecentMessage(@RequestBody Map<String, Integer> params){
        
        return null;
    }

}
