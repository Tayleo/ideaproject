package com.example.demo.dao;

import com.example.demo.bean.permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface permissionMapper {
    int deleteByPrimaryKey(Integer perId);

    int insert(permission record);

    int insertSelective(permission record);

    permission selectByPrimaryKey(Integer perId);

    List<permission> selectAll(Integer start,Integer end);

    int updateByPrimaryKeySelective(permission record);

    int updateByPrimaryKey(permission record);
}