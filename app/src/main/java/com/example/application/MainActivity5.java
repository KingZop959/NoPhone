package com.example.application;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends MainActivity4{
    Chronometer ch ;
    Button start ;
    Button button1;
    static int time = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //获取计时器组件
        ch = (Chronometer) findViewById(R.id.test);
        //获取开始按钮
        //启动计时器
        ch.setBase(SystemClock.elapsedRealtime() );
        ch.start();
        //退出修炼模式
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time =(int)((SystemClock.elapsedRealtime() - ch.getBase())/1000);
                if(time >= 0&&time <= 120){
                    userRole.setGrade(1);
                    userRole.setDefend(10*time);
                    userRole.setAtk(12*time+1);
                    userRole.setHP(100*time);
                    userRole.setExe(50*time);
                }
                else if(time > 600 && time <= 1200 ){
                    userRole.setGrade(2);
                    userRole.setDefend(5*time+6000);
                    userRole.setAtk(6*time+7201);
                    userRole.setHP(10*time+ 60000);
                    userRole.setExe(20*time+30000);
                }
                else if(time > 1200 && time <= 1800 ){
                    userRole.setGrade(3);
                    userRole.setDefend(2*time+9000);
                    userRole.setAtk(2*time+10801);
                    userRole.setHP(3*time+ 66000);
                    userRole.setExe(10*time + 42000);
                }
                else if(time > 1800 ){
                    userRole.setGrade(3);
                    userRole.setDefend(1*time+10100);
                    userRole.setAtk(1*time+12001);
                    userRole.setHP(1*time+ 67800);
                    userRole.setExe(2*time + 48000);
                }

                FileHelper fileHelper = new FileHelper(MainActivity5.this);
                try {
                    fileHelper.save("name.txt",userRole.name);
                    fileHelper.save("HP.txt",String.valueOf(userRole.getHP()));
                    fileHelper.save("defend.txt",String.valueOf(userRole.getDefend()));
                    fileHelper.save("atk.txt",String.valueOf(userRole.getAtk()));
                    fileHelper.save("grade.txt",String.valueOf(userRole.getGrade()));
                    fileHelper.save("exe.txt",String.valueOf(userRole.getExe()));
                    fileHelper.save("sex.txt",String.valueOf(userRole.getSex()));
                    Log.e("abc", "onClick: "+fileHelper.read("HP.txt"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.e("abc", "");
                Intent intent = new Intent();
                //切换到登录页面
                intent.setClass(MainActivity5.this, MainActivity6.class);
                startActivity(intent);
                finish();
            }
        });


        //为Chronomter绑定事件监听器
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //如果计时到现在超过了十小时秒
                if ( SystemClock.elapsedRealtime() - ch.getBase() > 36000 * 1000) {
                    ch.stop();
                    start.setEnabled(true);
                }
            }
        });
    }
    public static int getTime(){
        return time;
    }
}