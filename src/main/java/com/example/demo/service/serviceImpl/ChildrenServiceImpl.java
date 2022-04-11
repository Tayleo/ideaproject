package com.example.demo.service.serviceImpl;

import com.example.demo.bean.children;

import com.example.demo.dao.childrenMapper;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.ChildrenService;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ChildrenServiceImpl implements ChildrenService {

    @Autowired
    childrenMapper childrenMapper;


    @Override
    public List<children> getallChildren() {

        return childrenMapper.selectallchildren();
    }

    @Override
    public Result getChildrenbyId(Map<String,Object> map) {
        try {
            int id= (int) map.get("user_id");
            children children=childrenMapper.selectByPrimaryKey(id);
            return ResultGenerator.genSuccessResult(children);
        }catch(SqlSessionException e){
            return ResultGenerator.genFailResult("数据库查询失败");
        }
    }

    @Override
    public Result addChildren(Map<String,Object> map) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM

        int user_id=(int)map.get("user_id");
        children chil=new children();
        Map map1=(Map)map.get("forminfo");
        Map userinfo= (Map) map1.get("userInfo");
        Map lostinfo=(Map) map1.get("lost");
        //chil=MaptoBean.mapToBean(map1,chil);
        System.out.println(map1);
        chil.setUserId(user_id);

        chil.setRealName((String) userinfo.get("name"));
       // chil.setGender((Byte) userinfo.get("sex"));
        String age= (String) userinfo.get("age");
        chil.setAge(Integer.parseInt(age));
        String time= (String) userinfo.get("birthday");
        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        chil.setBirthday(date);
        chil.setNowAddress((String) userinfo.get("address"));
        chil.setPhone((String) userinfo.get("phone"));
        chil.seteMail((String) userinfo.get("email"));

        chil.setLostTime((String) lostinfo.get("time"));
        chil.setLostCloth((String) lostinfo.get("cloth"));
        chil.setLostAddress((String) lostinfo.get("address"));
        chil.setLostHeight((String) lostinfo.get("height"));
        chil.setDetails((String) lostinfo.get("details"));

        //children= MaptoBean.mapToBean(,children);
        childrenMapper.insert(chil);
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public Result updateChildren(Map<String, Object> map) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        int user_id=(int)map.get("user_id");
        children chil=new children();
        Map map1=(Map)map.get("forminfo");
        Map userinfo= (Map) map1.get("userInfo");
        Map lostinfo=(Map) map1.get("lost");
        //chil=MaptoBean.mapToBean(map1,chil);
        System.out.println(map1);
        chil.setUserId(user_id);

        chil.setRealName((String) userinfo.get("name"));
        // chil.setGender((Byte) userinfo.get("sex"));
//        String age= (String) userinfo.get("age");
//        chil.setAge(Integer.parseInt(age));
        chil.setAge((int)userinfo.get("age"));
        String time= (String) userinfo.get("birthday");
        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        chil.setBirthday(date);
        chil.setNowAddress((String) userinfo.get("address"));
        chil.setPhone((String) userinfo.get("phone"));
        chil.seteMail((String) userinfo.get("email"));

        chil.setLostTime((String) lostinfo.get("time"));
        chil.setLostCloth((String) lostinfo.get("cloth"));
        chil.setLostAddress((String) lostinfo.get("address"));
        chil.setLostHeight((String) lostinfo.get("height"));
        chil.setDetails((String) lostinfo.get("details"));

        childrenMapper.updateByPrimaryKey(chil);
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public Result deleteChildren(Map<String, Object> map) {
        int id=(int)map.get("user_id");
        childrenMapper.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }
}
