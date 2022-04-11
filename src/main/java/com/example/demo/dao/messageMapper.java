package com.example.demo.dao;

import com.example.demo.bean.message;
import org.springframework.stereotype.Repository;

@Repository
public interface messageMapper {
    int deleteByPrimaryKey(Integer infoId);

    int insert(message record);

    int insertSelective(message record);

    message selectByPrimaryKey(Integer infoId);

    int updateByPrimaryKeySelective(message record);

    int updateByPrimaryKey(message record);
}