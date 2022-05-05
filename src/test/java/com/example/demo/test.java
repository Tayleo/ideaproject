package com.example.demo;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.qiniu.util.Json;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
public class test {


    @Test
        public void log4j2()   {

            String test="{acceptId:13,type:0,content:\"hahahhahha\"}";
            JSONObject jsonObject = JSON.parseObject(test);
            System.out.println(jsonObject.getInteger("acceptId"));
             System.out.println(jsonObject.getInteger("type"));
            System.out.println(jsonObject.getString("content"));
//        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
//        //    count=stream.count();
////            stream.skip(count-4).limit(4);

//            stream.forEach(ele -> {
//                System.out.println(ele);
//            });
//        } catch (IOException e){
//            System.out.println("查询错误");
//        }

        // 读取文件内容到Stream流中，按行读取
//        Stream<String> lines = null;
//        try {
//            lines = Files.lines(Paths.get(fileName))
//                            .skip(3)
//                            .limit(10);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 随机行顺序进行数据处理
//        lines.forEach(ele -> {
//            System.out.println(ele);
//        });

    }

}
