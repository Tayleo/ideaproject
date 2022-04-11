package com.example.demo;

import com.jayway.jsonpath.internal.function.numeric.Min;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.xmlunit.builder.Input;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void main(){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        System.out.println(s);
        String s1="acbcca";
        int cnum=0;
        int anum=0;
        int bnum=0;
        char[] chatList=s.toCharArray();
        for(int i=0;i<chatList.length;i++){
            if(chatList[i]=='a') anum++;
            else if(chatList[i]=='b') bnum++;
            else if(chatList[i]=='c') cnum++;
        }
        int minc= cnum/2;
        int tempmin=Math.min(anum,bnum);
        tempmin=Math.min(tempmin,minc);
        System.out.println(tempmin);

    }

}
