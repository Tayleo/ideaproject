package com.example.demo;

import com.jayway.jsonpath.internal.function.numeric.Min;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.xmlunit.builder.Input;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
class DemoApplicationTests {



    @Test
    public void main(){
        //时间从后端获取，不由前端传输
        Date time = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            time=formatter.parse(String.valueOf(time));   //将字符串转化为Date
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(time);
    }

}
