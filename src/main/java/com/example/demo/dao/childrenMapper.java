package com.example.demo.dao;

import com.example.demo.bean.children;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface childrenMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(children record);

    int insertSelective(children record);

    children selectByPrimaryKey(Integer userId);

    List<children> selectallchildren();

    int updateByPrimaryKeySelective(children record);

    int updateByPrimaryKey(children record);
}