package com.example.demo;
import com.example.demo.utils.QiniuUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static void main(String[] args)  {
        int x=10;
        List<Integer> list=new ArrayList<>();
        while(x!=0){
            list.add(x%2);
            x=x/2;
        }
        int b=1;
        int sum=0;
        for (int i = list.size()-1; i >=0; i--) {
            sum=sum+b*list.get(i);
            b=b*2;
        }
        System.out.println(sum);
    }
}
