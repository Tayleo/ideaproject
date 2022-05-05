package com.example.demo.dao;

import com.example.demo.bean.role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface roleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(role record);

    int insertSelective(role record);

    List<role> selectAll();

    role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(role record);

    int updateByPrimaryKey(role record);
}