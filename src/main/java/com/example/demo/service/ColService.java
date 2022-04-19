package com.example.demo.service;

import com.example.demo.result.Result;

import java.util.Map;

public interface ColService {
    Result addcol(Map params);
    Result deletecol(Map params);
    Result deletecols(Map params);
    Result lookcols(Map params);
}
