package com.example.demo.dao;

import com.example.demo.bean.info_status;
import org.springframework.stereotype.Repository;

@Repository
public interface info_statusMapper {
    int deleteByPrimaryKey(Integer infoStatusId);

    int insert(info_status record);

    int insertSelective(info_status record);

    info_status selectByPrimaryKey(Integer infoStatusId);

    int updateByPrimaryKeySelective(info_status record);

    int updateByPrimaryKey(info_status record);
}