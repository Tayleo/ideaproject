package com.example.demo.dao;


import com.example.demo.bean.match;
import com.example.demo.bean.returndata.matchinfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface matchMapper {
    int deleteByPrimaryKey(Integer userId,Integer matchId);
    int deleteMatchs(Map<String,Object> map);

    int insert(match record);

    int insertSelective(match record);

    match selectByPrimaryKey(Integer userId,Integer matchId);
    List<matchinfo> selectMatchInfoRe(Integer userId);
    List<matchinfo> selectMatchInfoCl(Integer userId);

    int updateByPrimaryKeySelective(match record);

    int updateByPrimaryKey(match record);
}