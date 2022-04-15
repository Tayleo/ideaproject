package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.users;
import com.example.demo.config.wechatToken;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.serviceImpl.UsersServiceImpl;
import com.example.demo.utils.HttpClientUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/UsersController")
@CrossOrigin
public class UsersController {

    @Autowired
    private HttpClientUtil httpClientUtil;

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    MessageController messageController;

//    @RequestMapping("login")
//    public Result userLogin( ){
//        Subject subject= SecurityUtils.getSubject();
//        String openid="123";
//        String sessionlry="456";
//        wechatToken token=new wechatToken(openid,sessionlry);
//        subject.login(token);
//        return null;
//    }



        /**
         *登录功能（整合shiro)
         * @param map  userinfo和code
         * @return
         */

    @RequestMapping("login")
    public Result userLogin(@RequestBody Map<String,Object> map ){

        //先判断数据中是否有这个用户，如果没有就加入到数据库（通过openid判断）
        System.out.println(map);
        String appid="wx301f59caddc4fd2a";
        String secret="f6b0f8f1852e2c5f085604d379eb9f64";
        String code= (String) map.get("code");
        //拼接sql
        String loginUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid +
                "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";

        String result = httpClientUtil.sendHttpGet(loginUrl);

        JSONObject jsonObject = JSON.parseObject(result);//将json字符串转化为jsonobject
        String openid = jsonObject.get("openid").toString(); // 获取openId
        String session_key = jsonObject.get("session_key").toString();//获取session_key

        //将得到的openid在数据库中查询
        users user = usersService.selectByOpenId(openid);
        if(user==null || user.getUserId()==null){  //用户第一次登录，数据库中没有数据
            //获取七牛云聊天id
            Map<String,String> mapadduser= new HashMap();
            mapadduser.put("user_name","test6");
            Long qiniuyunid=messageController.addUser(mapadduser);

            //将数据添加到数据库
            user=new users();
            HashMap<String,Map> userinfo= (HashMap<String, Map>) map.get("userinfo");
            HashMap<String,String> userInfos= (HashMap<String, String>) userinfo.get("userInfo");
            user.setUserNickname(userInfos.get("nickName"));
            user.setOpenId(openid);
            user.setSessionKey(session_key);
            user.setUserAvatorUrl(userInfos.get("avatarUrl"));
            user.setQiniuyunId(qiniuyunid);
            usersService.insertuser(user);
        }else{           //用户有数据则返回openid
            //buzhi
        }

        /*整合shiro*/
        Subject subject= SecurityUtils.getSubject();
        //UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        wechatToken token=new wechatToken(openid,session_key);
        try{
            subject.login(token);  //此方法会进入到userRealm的AuthenticationInfo的方法中，token会传过去
        }catch(UnknownAccountException e){ //用户名不存在
            System.out.println("用户名不存在");
            e.printStackTrace();
        }catch(IncorrectCredentialsException e){   //密码错误
            System.out.println("密码错误");
            e.printStackTrace();
        }

        Map resultmap =new HashMap();
        resultmap.put("open_id",openid);
        users u=(users)subject.getPrincipal();
        resultmap.put("role_id",u.getUserRole());
        resultmap.put("user_id",u.getUserId());

        return ResultGenerator.genSuccessResult(resultmap);
    }


    /**
     * 取消用户微信绑定，置空服务器端用户表对应记录的openId，并置空本地用户的openid信息即可
     * @param params
     * @return
     */
    @RequestMapping("CancelBindWechat")
    public Result CancelBindWechat(@RequestBody Map params){

        return usersService.CancelBindWechat(params);
    }
    /**
     * 新增一个用户
     * @param params
     * @return
     */
    @RequestMapping("addUser")
    public Result addUser(@RequestBody Map params){
        return null;
    }

    /**
     * 用户修改基础信息
     * @param params
     * @return
     */
    @RequestMapping("changeUserinfo")
    public Result changeUserinfo(@RequestBody Map params){
        return null;
    }

    /**
     * 用户修改角色
     * @param params
     * @return
     */
    @RequestMapping("changeRole")
    public Result changeRole(@RequestBody Map params){
        int user_id= (int) params.get("user_id");
        int role_id=(int) params.get("role_id")+2;

        usersService.changeRole(user_id,role_id);
        return ResultGenerator.genSuccessResult();
    }


}
