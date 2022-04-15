package com.example.demo;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        List<Integer> list=new ArrayList<>();
//        list.add(20);
//        list.add(6);
//        list.add(20);
//        inverse(list);
        String s;
        while(sc.hasNext()){
            s=sc.next();

            s.replaceAll("\""," ");
            System.out.println(s);
            int x=sc.nextInt();
            System.out.println(x);
        }

    }
    public static List<Integer> inverse(List<Integer> list){
        List<Integer> inv=new ArrayList<>();
        List<Integer> se=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int b=1;
            int sum=0;
            if(list.get(i)%2==0){   //偶数
                int temp=list.get(i);
                while(temp!=0){
                    inv.add(temp%2);
                    temp=temp/2;
                }
                for (int j = inv.size()-1; j >=0 ; j--) {
                    sum=sum+inv.get(j)*b;
                    b=b*2;
                }
                se.add(sum);
                System.out.println(sum);
            }else{
                se.add(list.get(i));
            }
            inv.clear();
        }
        return list;
    }
}
