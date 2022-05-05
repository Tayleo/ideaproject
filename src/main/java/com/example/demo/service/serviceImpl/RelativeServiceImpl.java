package com.example.demo.service.serviceImpl;

import com.example.demo.bean.children;
import com.example.demo.bean.relative;
import com.example.demo.dao.relativeMapper;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.RelativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RelativeServiceImpl implements RelativeService {


    @Autowired
    relativeMapper relativemapper;


    @Override
    public List<relative> getallRelative(int pageNum,int pagSize) {

        int start = (pageNum-1)*pagSize;
        int end=pageNum*pagSize;
        List<relative> relatives=relativemapper.selectAllRelative();

        return relatives;
    }

    @Override
    public relative getRelativeById(int user_id) {
        relative r=relativemapper.selectByPrimaryKey(user_id);
        return r;
    }

    @Override
    public Result addRelative(Map map) {

        System.out.println(map);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM

        String imgurl=(String)map.get("imgurl");
        int user_id=(int)map.get("user_id");
        Map map1=(Map)map.get("forminfo");

        Map userinfo= (Map) map1.get("userInfo");
        Map lostinfo=(Map) map1.get("lost");
        String relation=(String)map1.get("relation");

        relative rela=new relative();
        System.out.println(map1);
        rela.setUserId(user_id);
        rela.setChildrenUrl(imgurl);

        rela.setLostAddress((String) lostinfo.get("address"));
        rela.setLostCloth((String) lostinfo.get("cloth"));
        rela.setDetails((String) lostinfo.get("details"));
        rela.setLostHeight((String) lostinfo.get("height"));
        rela.setLostTime((String) lostinfo.get("time"));

        rela.setRelation(relation);

        rela.setChildrenAge(Integer.valueOf((String) userinfo.get("age")) );
        String time= (String) userinfo.get("birthday");
        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        rela.setBirthday(date);
        rela.seteMail((String) userinfo.get("email"));
        rela.setFeatures((String) userinfo.get("features"));
        rela.setChildrenName((String) userinfo.get("name"));
        rela.setPhone((String) userinfo.get("phone"));
        String sex=(String)userinfo.get("sex");
        if(sex.equals("男")){
            rela.setChildrenGender((byte) 1);
        }else{
            rela.setChildrenGender((byte) 0);
        }
        relativemapper.insertSelective(rela);
        return ResultGenerator.genSuccessResult();
    }
}
