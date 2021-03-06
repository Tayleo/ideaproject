package com.example.demo.dao;

import com.example.demo.bean.relative;
import com.example.demo.bean.returndata.admininfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface relativeMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(relative record);

    int insertSelective(relative record);

    relative selectByPrimaryKey(Integer userId);

    List<relative> selectAllRelative();

    List<admininfo> noRelease(Integer start,Integer end);

    int Release(Integer user_id);

    int refuse(Integer user_id);

    int updateByPrimaryKeySelective(relative record);

    int updateByPrimaryKey(relative record);
}