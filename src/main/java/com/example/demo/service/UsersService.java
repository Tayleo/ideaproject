package com.example.demo.service;


import com.example.demo.bean.users;
import com.example.demo.result.Result;

import java.util.Map;

public interface UsersService {
    public Result CancelBindWechat(Map map);

    public users selectByOpenId (String open_id);
    int insertuser(users users);
    int changeRole(int user_id,int role_id);

}
