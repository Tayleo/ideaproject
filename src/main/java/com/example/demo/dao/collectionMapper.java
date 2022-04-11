package com.example.demo.dao;

import com.example.demo.bean.col;
import org.springframework.stereotype.Repository;

@Repository
public interface collectionMapper {
    int deleteByPrimaryKey(Integer colId);

    int insert(col record);

    int insertSelective(col record);

    col selectByPrimaryKey(Integer colId);

    int updateByPrimaryKeySelective(col record);

    int updateByPrimaryKey(col record);
}