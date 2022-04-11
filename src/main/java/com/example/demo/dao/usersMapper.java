package com.example.demo.dao;

import com.example.demo.bean.users;
import org.springframework.stereotype.Repository;

@Repository
public interface usersMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(users record);

    int insertSelective(users record);

    users selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(users record);

    int updateByPrimaryKey(users record);

    int updateRole(int user_id,int role_id);

    int setopenidnull(Integer userId);

    users selectByOpenId(String open_id);
}