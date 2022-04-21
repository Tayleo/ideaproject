package com.example.demo.service;

import com.example.demo.result.Result;

import java.util.Map;

public interface MatchService {
    Result startMatch(Map params);
    Result deleteMatch(Map params);
    Result deleteMatchs(Map params);
    Result getMatchList(Map params);
}
