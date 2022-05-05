package com.example.demo.dao;

import com.example.demo.bean.logs;
import org.springframework.stereotype.Repository;

@Repository
public interface logsMapper {
    int insert(logs record);

    int insertSelective(logs record);
}