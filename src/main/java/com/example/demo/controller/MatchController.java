package com.example.demo.controller;

import com.example.demo.result.Result;
import com.example.demo.service.serviceImpl.MatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("MatchController")
public class MatchController {

    @Autowired
    MatchServiceImpl matchService;

    /**
     * 1.获取匹配记录
     * @param params
     * @return
     */
    @RequestMapping("getMatchList")
    public Result getMatchList(@RequestBody Map params){
        return matchService.getMatchList(params);
    }

    /**
     * 2.开始匹配
     * @param params
     * @return
     */
    @RequestMapping("startMatch")
    public Result startMatch(@RequestBody Map params){
        return matchService.startMatch(params);
    }

    /**
     * 3.删除一条匹配记录
     * @param params
     * @return
     */
    @RequestMapping("deleteMatch")
    public Result deleteMatch(@RequestBody Map params){
        return matchService.deleteMatch(params);
    }

    /**
     *  4.批量删除匹配记录
     * @param params
     * @return
     */
    @RequestMapping("deleteMatchs")
    public Result deleteMatchs(@RequestBody Map params){
        return matchService.deleteMatchs(params);
    }
}
