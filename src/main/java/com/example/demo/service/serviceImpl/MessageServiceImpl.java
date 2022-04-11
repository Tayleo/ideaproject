package com.example.demo.service.serviceImpl;

import com.example.demo.bean.message;
import com.example.demo.dao.messageMapper;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    messageMapper messageMapper;


    @Override
    public Result getallmessage(int user_id) {




        return ResultGenerator.genSuccessResult();
    }
}
