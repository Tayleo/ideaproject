package com.example.demo.service.serviceImpl;

import com.example.demo.bean.permission;
import com.example.demo.bean.returndata.admininfo;
import com.example.demo.bean.role;
import com.example.demo.dao.*;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger logger=LogManager.getLogger("myLog");

    @Autowired
    MessageServiceImpl messageService;

    final
    roleMapper roleMapper;

    final
    permissionMapper permissionMapper;

    final
    logsMapper logsMapper;

    final
    relativeMapper relativeMapper;

    final
    childrenMapper childrenMapper;

    public AdminServiceImpl(permissionMapper permissionMapper, roleMapper roleMapper, logsMapper logsMapper, relativeMapper relativeMapper, childrenMapper childrenMapper) {
        this.permissionMapper = permissionMapper;
        this.roleMapper = roleMapper;
        this.logsMapper=logsMapper;
        this.relativeMapper=relativeMapper;
        this.childrenMapper=childrenMapper;
    }

    @Override
    public Result login() {
        return null;
    }

    @Override
    public Result getAllRole() {

        List<role> roleList;
        try{
            roleList=roleMapper.selectAll();
            logger.info("查看角色列表");
            return ResultGenerator.genSuccessResult(roleList);
        }catch(Exception e) {
            logger.error("查看角色列表");
            return ResultGenerator.genFailResult("查询失败");
        }
    }

    @Override
    public Result addupdateRole(Map params) {
        role r=new role();
        r.setRoleName((String)params.get("roleName"));
        r.setDetails((String)params.get("details"));
        //先在数据库中查询update是否有此角色
        try{
            if(params.get("roleId").equals(0)){
                roleMapper.insert(r);
                logger.info("新增角色");
            }else{
                r.setRoleId((int) params.get("roleId"));
                System.out.println(r.getRoleId());
                logger.info("修改角色信息");
                roleMapper.updateByPrimaryKey(r);
            }
            return ResultGenerator.genSuccessResult("编辑角色成功");
        }catch(Exception e) {
            System.out.println(e);
            logger.error("编辑角色");
            return ResultGenerator.genFailResult("编辑角色失败");
        }
    }



    @Override
    public Result deleteRole(Map params) {
       int roleId=(Integer)params.get("roleId");
        //先在数据库中查询是否有此角色
        try{
            roleMapper.deleteByPrimaryKey(roleId);
            logger.info("删除角色");
            return ResultGenerator.genSuccessResult("删除角色成功");
        }catch(Exception e) {
            logger.error("删除角色");
            return ResultGenerator.genFailResult("删除角色失败");
        }
    }

    @Override
    public Result getPermission(Map params) {

        int start=((int)params.get("page")-1)*(int)params.get("limit");
        int end=(int)params.get("page")*(int)params.get("limit");

        try{
            List<permission> permissions=permissionMapper.selectAll(start,end);
            logger.info("查询权限列表");
            return ResultGenerator.genSuccessResult(permissions,permissions.size());
        }catch(Exception e){
            logger.error("查询权限列表");
            return ResultGenerator.genFailResult("查询失败");
        }

    }

    @Override
    public Result deletePermission(Map params) {
        int perid=(int)params.get("id");
        try{
            permissionMapper.deleteByPrimaryKey(perid);
            logger.info("删除权限");
            return ResultGenerator.genSuccessResult("删除成功");
        }catch(Exception e){
            logger.error("删除权限");
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    @Override
    public Result addupdatePermission(Map params) {
        permission p=new permission();
        p.setPerName((String)params.get("perName"));
        p.setPermission((String)params.get("permission"));
        //先在数据库中查询update是否有此角色
        try{
            if(params.get("perId").equals(-1)){
                permissionMapper.insert(p);
            }else{
                p.setPerId((int)params.get("perId"));
                permissionMapper.updateByPrimaryKey(p);
            }
            logger.info("修改权限信息");
            return ResultGenerator.genSuccessResult("编辑权限成功");
        }catch(Exception e) {
            System.out.println(e);
            logger.error("修改权限信息");
            return ResultGenerator.genFailResult("编辑权限失败");
        }
    }


    @Override
    public Result relativeList(Map params) {
        int start=((int)params.get("page")-1)*(int)params.get("limit");
        int end=(int)params.get("page")*(int)params.get("limit");

        try{
            List<admininfo> admininfoList=relativeMapper.noRelease(start,end);
            logger.info("查询寻亲者列表");
            return ResultGenerator.genSuccessResult(admininfoList);
        }catch(Exception e){
            logger.error("查询寻亲者列表");
            return ResultGenerator.genFailResult("查询失败");
        }

    }

    @Override
    public Result childrenList(Map params) {
        int start=((int)params.get("page")-1)*(int)params.get("limit");
        int end=(int)params.get("page")*(int)params.get("limit");
        try{
            List<admininfo> admininfoList=childrenMapper.noRelease(start,end);
            logger.info("查询走失者列表");
            return ResultGenerator.genSuccessResult(admininfoList);
        }catch(Exception e){
            logger.error("查询走失者列表");
            return ResultGenerator.genFailResult("查询失败");
        }
    }



    @Override
    public Result agreeRelease(Map params) {
        ArrayList<Integer> userList=(ArrayList<Integer>)params.get("user_id");
        int role_id=(int)params.get("role_id");
        try{
            if (role_id==2){
                //如果身份为走失者
                for (int i = 0; i <userList.size() ; i++) {
                    childrenMapper.Release(userList.get(i));
                }

            }else{
                for (int i = 0; i <userList.size() ; i++) {
                    relativeMapper.Release(userList.get(i));

                }
            }
            logger.info("同意用户发布信息");
            return ResultGenerator.genSuccessResult("成功");
        }catch(Exception e){
            logger.error("同意用户发布信息");
            return ResultGenerator.genFailResult("发布失败");
        }
    }

    @Override
    public Result disagree(Map params) {

        int id=(int)params.get("id");
        int role_id=(int)params.get("role_id");
        String reason=(String)params.get("reason");
        Map<String,Object> message=new HashMap<>();
        Date date = new Date();
        message.put("send_id",0);
        message.put("accepr_id",id);
        message.put("type",0);
        message.put("content",reason);
        message.put("time",date.toString());
        try{
            if(role_id==2){
                childrenMapper.refuse(id);
            }else{
                relativeMapper.refuse(id);
            }
            messageService.sendMessage(message);
            logger.info("不同意用户发布信息");
            return ResultGenerator.genSuccessResult("拒绝成功");
        }catch(Exception e){
            System.out.println(e);
            logger.error("不同意用户发布信息");
            return ResultGenerator.genFailResult("拒绝信息发布失败");
        }
    }

    @Override
    public Result getLogs(Map params) {
        String fileName = "logs/LogTest.log";
//        int start=((int)params.get("page")-1)*(int)params.get("limit");
//        int end=(int)params.get("page")*(int)params.get("limit");
        int page=(int)params.get("page");
        int limit=(int)params.get("limit");
        Long start;
        Long count=0L;
        Stream<String> stream=null;
        try {
            count = Files.lines(Paths.get(fileName)).count();
            if(count-limit*page<0){
                start=0L;
                limit= (int) (count-limit*(page-1));
            }else {
                start=count-limit*page;
            }
            stream = Files.lines(Paths.get(fileName));
            List<String> list=stream.skip(start).limit(limit).collect(Collectors.toList());

            logger.info("获取日志列表");
            return ResultGenerator.genSuccessResult(list,list.size());
        } catch (IOException e){
            logger.error("获取日志列表");
            return ResultGenerator.genFailResult("获取日志列表失败");
        } finally {
            stream.close();
        }
    }
}
