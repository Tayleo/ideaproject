package com.example.demo.controller;

import com.example.demo.result.Result;
import com.example.demo.service.serviceImpl.ColServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("CollectionController")
public class CollectionController {

    @Autowired
    ColServiceImpl colService;

    /**
     * 1、查看我的收藏列表
     * @param params
     * @return
     */
    @RequestMapping("lookColList")
    public Result lookColList(@RequestBody Map params){

        return colService.lookcols(params);
    }

    /**
     * 2、删除我的一个收藏
     * @param params
     * @return
     */
    @RequestMapping("deleteOneCol")
    public Result deleteOneCol(@RequestBody Map params){
        return colService.deletecol(params);
    }

    /**
     * 3、批量删除我的收藏
     * @param params
     * @return
     */
    @RequestMapping("deleteCols")
    public Result deleteCols(@RequestBody Map params){
        return colService.deletecols(params);
    }
    /**
     * 3、4、新增一个收藏
     * @param params
     * @return
     */
    @RequestMapping("addCol")
    public Result addCol(@RequestBody Map params){

        return colService.addcol(params);

    }

}
