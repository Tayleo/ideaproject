package com.example.demo.dao;


import com.example.demo.bean.match;
import org.springframework.stereotype.Repository;

@Repository
public interface matchMapper {
    int deleteByPrimaryKey(Integer userId,Integer matchId);

    int insert(match record);

    int insertSelective(match record);

    match selectByPrimaryKey(Integer userId,Integer matchId);

    int updateByPrimaryKeySelective(match record);

    int updateByPrimaryKey(match record);
}