package com.example.demo.service.serviceImpl;

import com.example.demo.bean.returndata.matchinfo;
import com.example.demo.bean.returndata.starinfo;
import com.example.demo.dao.matchMapper;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    matchMapper matchMapper;

    @Override
    public Result startMatch(Map params) {
        return null;
    }

    @Override
    public Result deleteMatch(Map params) {
        int user_id=(int)params.get("user_id");
        int match_id=(int) params.get("match_id");
        try{
            int i=matchMapper.deleteByPrimaryKey(user_id,match_id);
            if(i>0){
                return ResultGenerator.genSuccessResult("删除成功");
            }else{
                return ResultGenerator.genSuccessResult("无匹配记录");
            }
        }catch(Exception e){
            System.out.println(e);
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    @Override
    public Result deleteMatchs(Map params) {
        int user_id=(int)params.get("user_id");
        ArrayList<Integer> list=(ArrayList)params.get("list");
        Map map=new HashMap<String,Object>();
        map.put("userId",user_id);
        map.put("list",list);
        try{
            int i=matchMapper.deleteMatchs(map);
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
    public Result getMatchList(Map params) {
        int user_id=(int)params.get("user_id");
        List<matchinfo> matchinfoList=new ArrayList<>();
        try{
            List<matchinfo> matchinfoList1=matchMapper.selectMatchInfoCl(user_id);
            List<matchinfo> matchinfoList2=matchMapper.selectMatchInfoRe(user_id);

            matchinfoList.addAll(matchinfoList1);
            matchinfoList.addAll(matchinfoList2);
            return ResultGenerator.genSuccessResult(matchinfoList);
        }catch(Exception e){
            System.out.println(e);
            return ResultGenerator.genFailResult("查询失败");
        }
    }
}
