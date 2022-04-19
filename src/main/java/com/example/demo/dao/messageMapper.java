package com.example.demo.dao;

import com.example.demo.bean.message;
import com.example.demo.bean.returndata.msgInfo;
import com.example.demo.bean.returndata.msglast;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface messageMapper {
    int deleteByPrimaryKey(Integer infoId);

    int insert(message record);

    int insertSelective(message record);

    message selectByPrimaryKey(Integer infoId);

    List<msglast> getLastMessageById(Integer userId);
    List<msgInfo> getMessageBefore(Integer userId,Integer anotherId,Integer start,Integer count);

    int updateByPrimaryKeySelective(message record);

    int updateByPrimaryKey(message record);
}