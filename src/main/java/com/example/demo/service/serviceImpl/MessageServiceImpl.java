package com.example.demo.service.serviceImpl;

import com.example.demo.bean.message;
import com.example.demo.bean.returndata.msgInfo;
import com.example.demo.bean.returndata.msglast;
import com.example.demo.dao.messageMapper;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    messageMapper messageMapper;


    @Override
    public Result getallmessage(int user_id) {
        //查询时间在一年内的所有数据
        List<msglast> msgs=messageMapper.getLastMessageById(user_id);

        return ResultGenerator.genSuccessResult(msgs);
    }

    @Override
    public Result getMessageBefore(int user_id, int another_id,int page,int pagesize) {

        int start=(page-1)*pagesize;
        int count=pagesize;
        List<msgInfo> msgInfos=messageMapper.getMessageBefore(user_id,another_id,start,count);
        return ResultGenerator.genSuccessResult(msgInfos);
    }

    @Override
    public Result sendMessage(Map<String, Object> params) {
        //从params中解析出数据
        int send_id=(int)params.get("send_id");
        int accept_id=(int)params.get("accepr_id");
        int i=(int) params.get("type");
        byte type=(byte)i;
        String content=(String)params.get("content");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time= null;
        try {
            time = sdf.parse((String) params.get("time"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //添加到数据中

        message msgsend=new message();
        message msgaccept=new message();

        msgsend.setAcceptId(accept_id);
        msgsend.setSendId(send_id);
        msgsend.setRealAcceptId(accept_id);
        msgsend.setRealSendId(send_id);
        msgsend.setType(type);
        msgsend.setInfoContent(content);
        msgsend.setInfoTime(time);
       // msgsend.setStatus(1);

        msgaccept.setAcceptId(send_id);
        msgaccept.setSendId(accept_id);
        msgaccept.setRealAcceptId(accept_id);
        msgaccept.setRealSendId(send_id);
        msgaccept.setType(type);
        msgaccept.setInfoContent(content);
        msgaccept.setInfoTime(time);

        System.out.println(msgsend);
        System.out.println(msgaccept);

        try{
            messageMapper.insert(msgaccept);
            messageMapper.insert(msgsend);
            return ResultGenerator.genSuccessResult();
        }catch(Exception e){
            return ResultGenerator.genFailResult("发送消息失败");
        }
    }
}
