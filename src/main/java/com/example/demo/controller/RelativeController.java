package com.example.demo.controller;

import com.example.demo.bean.relative;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.RelativeService;
import com.example.demo.service.serviceImpl.RelativeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/RelativeController")
@CrossOrigin
public class RelativeController {

    @Autowired
    RelativeServiceImpl relativeService;

    /**
     * 查看所有寻亲者发布的信息
     * @return
     */
    @RequestMapping("getallRelative")
    public Result getallRelative(){

        Result result= ResultGenerator.genSuccessResult(relativeService.getallRelative());

        return result;
    }

    /**
     * 通过用户id查看以及发布的信息
     * @param params
     * @return
     */
    @RequestMapping("getRelativebyid")
    public Result getRelativebyid(@RequestBody Map params){
        int user_id= (int) params.get("user_id");
        relative r=relativeService.getRelativeById(user_id);
        return ResultGenerator.genSuccessResult(r);
    }

    /**
     * 用户（寻亲者）新增信息
     * @param params
     * @return
     */
    @RequestMapping("addRelative")
    public Result addRelative(@RequestBody Map params){
        return null;
    }

    /**
     * 修改用户已经发布的信息
     * @param params
     * @return
     */
    @RequestMapping("changeRelative")
    public Result changeRelative(@RequestBody Map params){
        return null;
    }

    /**
     * 删除用户已经发布的信息
     * @param params
     * @return
     */
    @RequestMapping("deleteRelative")
    public Result deleteRelative(@RequestBody Map params){
        return null;
    }

}
