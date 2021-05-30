package com.example.application;

import java.util.Random;

public class ComUser{

    public String name;
    public int HP;
    public int defend;
    public int atk;
    public int grade;
    public int exe;
    public int sex;
    public ComUser(){
        Random ra =new Random();
        int x=ra.nextInt(4)+2;
        this.name=getRandomString(1,1)+getRandomString(0,x);
        this.grade=ra.nextInt(50)+1;
        this.atk=(ra.nextInt(30)+15)+grade;
        this.defend=(ra.nextInt(30)+15)+grade;
        this.HP=(ra.nextInt(30)+15)*10+grade;
    }
    public  String getRandomString(int p,int length){
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str1="abcdefghijklmnopqrstuvwxyz";
        String x;
        if(p==1)
            x=str;
        else
            x=str1;
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(26);
            sb.append(x.charAt(number));
        }
        return sb.toString();
    }
}
