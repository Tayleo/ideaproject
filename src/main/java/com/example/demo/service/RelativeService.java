package com.example.demo.service;

import com.example.demo.bean.relative;
import com.example.demo.bean.users;
import com.example.demo.result.Result;

import java.util.List;
import java.util.Map;

public interface RelativeService {
    List<relative> getallRelative(int pageNum,int pageSize);
    relative getRelativeById(int user_id);
    Result addRelative(Map map) throws Exception;
}
