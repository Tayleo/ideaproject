package com.example.demo.service.serviceImpl;

import com.example.demo.bean.relative;
import com.example.demo.dao.relativeMapper;
import com.example.demo.service.RelativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelativeServiceImpl implements RelativeService {


    @Autowired
    relativeMapper relativemapper;


    @Override
    public List<relative> getallRelative() {
        List<relative> relatives=relativemapper.selectAllRelative();

        return relatives;
    }

    @Override
    public relative getRelativeById(int user_id) {
        relative r=relativemapper.selectByPrimaryKey(user_id);

        return r;
    }
}
