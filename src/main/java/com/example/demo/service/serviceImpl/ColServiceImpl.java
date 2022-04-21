package com.example.demo.service.serviceImpl;

import com.example.demo.bean.col;
import com.example.demo.bean.returndata.starinfo;
import com.example.demo.dao.childrenMapper;
import com.example.demo.dao.collectionMapper;
import com.example.demo.dao.relativeMapper;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.ColService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ColServiceImpl implements ColService {

    @Autowired
    collectionMapper collectionMapper;

    @Autowired
    childrenMapper childrenMapper;

    @Autowired
    relativeMapper relativeMapper;

    @Override
    public Result addcol(Map params) {
        int user_id= (int) params.get("user_id");
        int col_id=(int)params.get("col_id");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time= null;
        try {
            time = sdf.parse((String) params.get("time"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        col c=new col();
        c.setUserId(user_id);
        c.setUserColId(col_id);
        c.setColTime(time);
        collectionMapper.insert(c);
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public Result deletecol(Map params) {
        int user_id=(int) params.get("user_id");
        int col_id=(int) params.get("col_id");
        try{
            int i=collectionMapper.deleteByPrimaryKey(user_id,col_id);
            if(i>0){
                return ResultGenerator.genSuccessResult("删除成功");
            }else{
                return ResultGenerator.genFailResult("删除失败");
            }
        }catch(Exception e){
            System.out.println(e);
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    @Override
    public Result deletecols(Map params) {
        int user_id =(int) params.get("user_id");
        ArrayList<Integer> list=(ArrayList)params.get("list");
        Map map=new HashMap<String,Object>();
        map.put("userId",user_id);
        map.put("list",list);
        try{
            int i=collectionMapper.deletecols(map);
            if(i>0){
                return ResultGenerator.genSuccessResult("删除成功");
            }else{
                return ResultGenerator.genFailResult("删除失败");
            }
        }catch(Exception e){
            System.out.println(e);
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    @Override
    public Result lookcols(Map params) {
        int user_id=(int)params.get("user_id");
        List<starinfo> starinfoList=new ArrayList<>();
        try{
                List<starinfo> starinfoList1=collectionMapper.selectStarInfoCl(user_id);
                List<starinfo> starinfoList2=collectionMapper.selectStarInfoRe(user_id);
                starinfoList.addAll(starinfoList1);
                starinfoList.addAll(starinfoList2);
                return ResultGenerator.genSuccessResult(starinfoList);
        }catch(Exception e){
            System.out.println(e);
            return ResultGenerator.genFailResult("查询失败");
        }
    }
}
