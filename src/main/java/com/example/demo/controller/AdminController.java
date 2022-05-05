package com.example.demo.controller;

import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.AdminService;
import com.example.demo.service.serviceImpl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/AdminController")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    /**
     * 实现管理员登录
     * @return
     */
    @RequestMapping("login")
    public Result login(){
        return null;
    }

    /**
     * 获取角色列表
     * @param params
     * @return
     */
    @RequestMapping("getRoles")
    public Result getAllRole(@RequestBody Map params){

        return adminService.getAllRole();
    }

    /**
     * 新增或者修改一个角色
     * @param params
     * @return
     */
    @RequestMapping("addUpdateRole")
    public Result addRole(@RequestBody Map params){
        System.out.println(params);
        return adminService.addupdateRole(params);
    }



    /**
     * 删除一个角色
     * @param
     * @return
     */
    @RequestMapping("deleteRole")
    public Result deleteRole(@RequestBody Map params){

        return adminService.deleteRole(params);
    }

    /**
     * 获取权限列表
     * @return
     */
    @RequestMapping("getPermission")
    public Result getPermission(@RequestBody Map params){
        System.out.println(params);
        return adminService.getPermission(params);
    }

    /**
     * 删除权限
     * @return
     */
    @RequestMapping("deletePermission")
    public Result deletePermission(@RequestBody Map params){
        //要将角色权限表中删除的权限也删除掉
        return adminService.deletePermission(params);
    }

    /**
     * 修改添加权限列表
     * @return
     */
    @RequestMapping("addUpdatePermission")
    public Result updatePermission(@RequestBody Map params){

        return adminService.addupdatePermission(params);
    }

    /**
     * 查看待审核走失者列表
     * @param params
     * @return
     */
    @RequestMapping("childrenList")
    public Result childrenList(@RequestBody Map params){

        return adminService.childrenList(params);
    }

    /**
     * 查看待审核寻亲者列表
     * @param params
     * @return
     */
    @RequestMapping("relativeList")
    public Result relativeList(@RequestBody Map params){

        return adminService.relativeList(params);
    }


    /**
     * 同意用户发布信息
     * @param params
     * @return
     */
    @RequestMapping("agreeRelease")
    public Result agreeRelease(@RequestBody Map params){

        return adminService.agreeRelease(params);

    }

    /**
     * 不同意用户发布信息（isRelease改为2，说明理由）
     * 1  用户（重新）提交，管理员同意
     * 0 用户提交，管理员未审核
     * 2 用户提交，管理员拒绝
     * @param params
     * @return
     */
    @RequestMapping("disagree")
    public Result disagree(@RequestBody Map params){
        System.out.println(params);
        return adminService.disagree(params);
    }

    /**
     * 查看日志列表
     * @param params
     * @return
     */
    @RequestMapping("logList")
    public Result logsList(@RequestBody Map params){
        return adminService.getLogs(params);
    }

}
