package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.users;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.serviceImpl.MessageServiceImpl;
import com.example.demo.utils.HttpClientUtil;
import com.google.gson.JsonObject;
import com.qiniu.util.Json;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/MessageController")
@CrossOrigin
public class MessageController {

    private static String user_id;   //七牛云服务器中的user_id


    @Autowired
    HttpClientUtil httpClientUtil;

    @Autowired
    MessageServiceImpl messageService;


    /**
     * 获取当前用户所有聊天记录(按照时间先后排序)
     * @return Result
     */
    @RequestMapping(value = "getMessage")
    public Result getMessage(@RequestBody Map<String, Integer> params){
//        Subject subject=SecurityUtils.getSubject();
//        users user=(users) subject.getPrincipal();
  //      int user_id=user.getUserId();
        int user_id=1;
        return messageService.getallmessage(user_id);
    }

    /**
     * 发送消息
     * @return Result
     */
    @RequestMapping(value = "sendMessages")
    public Result sendMessages(@RequestBody Map<String, Object> params){
//        Subject subject=SecurityUtils.getSubject();
//        users user=(users) subject.getPrincipal();
        //      int user_id=user.getUserId();
        int user_id=1;
        int accept=2;
        return messageService.sendMessage(params);
    }

    /**
     * 获取两个用户之间的所有聊天记录
     * @param params
     * @return
     */
    @RequestMapping(value = "getMessageBefore")
    public Result getMessageBefore(@RequestBody Map<String, Integer> params){
//        Subject subject=SecurityUtils.getSubject();
//        users user=(users) subject.getPrincipal();
        //      int user_id=user.getUserId();
        int page=params.get("page");
        int pagesize=params.get("pagesize");
        int user_id=1;
        int accept_id=params.get("accept_id");
        return messageService.getMessageBefore(user_id,accept_id,page,pagesize);
    }
























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

    /**
     * 在七牛云中新增一个用户
     * @param params
     * @return
     */
    @RequestMapping("adduser")
    public Long addUser(@RequestBody Map<String, String> params){
        String username=params.get("user_name");
        String password ="123456";
        String httpsql="https://api.maximtop.com/user/register/v2";
       // String data="{\"username\": "+username+",\"password\": "+password+"}";
        String data="{\"username\": \""+username+"\",\"password\": \""+password+"\"}";
        String result = httpClientUtil.sendHttpPostIM(httpsql,data);
        JSONObject jsonObject = JSON.parseObject(result);//将json字符串转化为jsonobject

        Map<String,Object> map=(Map)jsonObject.get("data");
        //得到当前用户的user_id之后需要将数据存入数据库
        System.out.println(map);
        Long qiniuyunuser_id=(Long)map.get("user_id");

        return qiniuyunuser_id;
    }

    /**
     * 发送消息
     * @param params
     * @return
     */
    @RequestMapping("sendMessage")
    public Result sendMessage(@RequestBody Map<String, String> params){

//        Subject subject= SecurityUtils.getSubject();
//        users u= (users) subject.getPrincipals();
//        Long qiniuyunId=u.getQiniuyunId();   //当前用户id;
        Long user_id = 6704850253376L;

        String target=params.get("target");
        String content=params.get("content");
        int content_type= Integer.parseInt(params.get("content_type"));

        String httpurl="https://api.maximtop.com/message/send";

        String param="{\"targets\": ["+target+"],\"type\": "+1+",\"content\":\""+content+"\",\"content_type\":"+content_type+"}";
        System.out.println(param);
        String result=httpClientUtil.sendHttpPostIMAnother(httpurl,param,user_id);

       // String result=httpClientUtil.sendHttpPostIMAnother(httpurl,param,u)
        JSONObject jsonObject= JSON.parseObject(result);
        return ResultGenerator.genSuccessResult(jsonObject);
    }

    /**
     * 取指定用户的最近会话列表
     * @param params
     * @return
     */
    @RequestMapping("getLastMessage")
    public Result getLastMessageList(@RequestBody Map<String, String> params){
//        Subject subject= SecurityUtils.getSubject();
//        users u= (users) subject.getPrincipals();
//        Long qiniuyunId=u.getQiniuyunId();   //当前用户id;
        Long user_id = 6704850253376L;

        String httpurl="https://api.maximtop.com/message/unread";

        String result=httpClientUtil.sendHttpsGet(httpurl,user_id);
        JSONObject jsonObject=JSON.parseObject(result);

        return ResultGenerator.genSuccessResult(jsonObject);
    }


    /**
     * 取指定会话的消息
     * @param params
     * @return
     */
    @RequestMapping("getConversation")
    public Result getConversation(@RequestBody Map<String, String> params){

        int limit=9;
        int msg_id_start=0;
        Long opposite_id=325898830L;  //对方id



        return null;
    }



    /**
     * 添加聊天好友
     * @param params
     * @return
     */
    @RequestMapping("addRoster")
    public Result addRoster(@RequestBody Map<String, Long> params){

//        Subject subject= SecurityUtils.getSubject();
//        users u= (users) subject.getPrincipals();
//        Long qiniuyunId=u.getQiniuyunId();   //当前用户id;
        Long userId = 6704850253376L;
        Long anotherid=params.get("qiniuyunid");

        String param="{\"list\": ["+anotherid+"]}";

        String httpsql="https://api.maximtop.com/user/add_roster";
        String result=httpClientUtil.sendHttpPostIMAnother(httpsql,param,userId);
        JSONObject jsonObject = JSON.parseObject(result);//将json字符串转化为jsonobject

        return ResultGenerator.genSuccessResult(jsonObject);
    }

    /**
     * 获取好友列表
     * @param params
     * @return
     */
    @RequestMapping("getRosters")
    public Result getRosters(@RequestBody Map<String, Long> params){

        String httpurl="https://api.maximtop.com/user/rosters";
//        Subject subject= SecurityUtils.getSubject();
//        users u= (users) subject.getPrincipals();
//        Long qiniuyunId=u.getQiniuyunId();   //当前用户id;
        Long userId = 6704850253376L;

        String result=httpClientUtil.sendHttpsGet(httpurl,userId);
        JSONObject jsonObject= JSON.parseObject(result);

        return ResultGenerator.genSuccessResult(jsonObject);
    }


}
