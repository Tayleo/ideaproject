package com.example.demo.service.serviceImpl;


import com.example.demo.bean.users;
import com.example.demo.dao.usersMapper;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.UsersService;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    usersMapper usersMapper;

    @Override
    public Result CancelBindWechat(Map map) {
        int user_id= (int) map.get("user_id");
        try {

            usersMapper.setopenidnull(user_id);
            return ResultGenerator.genSuccessResult();
        }catch (SqlSessionException e){
            return ResultGenerator.genFailResult("失败");
        }
    }

    @Override
    public users selectByOpenId(String open_id) {
        return usersMapper.selectByOpenId(open_id);
    }

    @Override
    public int insertuser(users users) {
        return usersMapper.insert(users);
    }

    @Override
    public int changeRole(int user_id, int role_id) {
        users user =new users();
        user.setUserId(user_id);
        user.setUserRole(role_id);
        return usersMapper.updateByPrimaryKeySelective(user);

    }
}
