package com.example.demo.dao;

import com.example.demo.bean.col;
import com.example.demo.bean.returndata.starinfo;
import com.example.demo.bean.transition.colbean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface collectionMapper {
    int deleteByPrimaryKey(Integer userId,Integer userColId);
    int deletecols(Map<String,Object> map);

    int insert(col record);

    int insertSelective(col record);

    List<starinfo> selectColTime(Integer userId);
    List<starinfo> selectStarInfoCl(Integer userId);
    List<starinfo> selectStarInfoRe(Integer userId);

    col selectByPrimaryKey(Integer userId,Integer userColId );

    int updateByPrimaryKeySelective(col record);

    int updateByPrimaryKey(col record);
}