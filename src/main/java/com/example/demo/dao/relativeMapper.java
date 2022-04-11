package com.example.demo.dao;

import com.example.demo.bean.relative;
import org.springframework.stereotype.Repository;

@Repository
public interface relativeMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(relative record);

    int insertSelective(relative record);

    relative selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(relative record);

    int updateByPrimaryKey(relative record);
}