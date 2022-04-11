package com.example.demo.service;


import com.example.demo.bean.children;
import com.example.demo.result.Result;

import java.util.List;
import java.util.Map;

public interface ChildrenService {
    List<children> getallChildren();
    Result getChildrenbyId(Map<String,Object> map);
    Result addChildren(Map<String,Object> map);
    Result updateChildren(Map<String,Object> map);
    Result deleteChildren(Map<String,Object> map);
}
