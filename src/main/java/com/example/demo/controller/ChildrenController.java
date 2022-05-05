package com.example.demo.controller;


import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.serviceImpl.ChildrenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ChildrenController")
@CrossOrigin
public class ChildrenController {

    @Autowired
    ChildrenServiceImpl childrenService;

    /**
     * 获取所有身份为走失者的信息
     * @return
     */
    @RequestMapping("getallChildren")
    public Result getallChildren(@RequestBody Map<String,Integer> params){
        int pagenum=params.get("pagenum");
        int pagesize=params.get("pagesize");
        return ResultGenerator.genSuccessResult(childrenService.getallChildren(pagenum,pagesize));
    }

    /**
     * 通过用户id查看用户发布信息
     * @param params
     * @return
     */
    @RequestMapping("getChildrenbyId")
    public Result getChildrenbyId(@RequestBody Map params) {
        return childrenService.getChildrenbyId(params);
    }

    /**
     * 一个身份为走失者的用户发布信息
     * @return
     */
    @RequestMapping("addChildren")
    public Result addChildren(@RequestBody Map params){

        return childrenService.addChildren(params);
    }

    /**
     * 修改以已经发布的信息
     */
    @RequestMapping("updateChildren")
    public Result updateChildren(@RequestBody Map<String,Object> params){

        return childrenService.updateChildren(params);
    }

    /**
     * 删除已经发布的信息（即将身份改变为游客或是寻亲者）
     */
    @RequestMapping("deleteChildren")
    public Result deleteChildren(@RequestBody Map<String,Object> params){

        return null;
    }
}
