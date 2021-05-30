package com.example.application;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.io.IOException;

public class MainActivity4 extends MainActivity2 {

    protected ImageView imageView;
    private String name;
    private static int grade;
    private static int Hp;
    private static int atk;
    private static int defend;
    private static int exe;
    private static String Name;
    private int photo = 0;
    int time = MainActivity5.getTime();
    int index;
    static Role userRole = new Role(MainActivity3.getName(),100,10,10,1,0,0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        photo = MainActivity3.getPhoto();
        imageView = (ImageView)findViewById(R.id.imageview);
        if(photo == 0||photo == 1) {
            imageView.setImageResource(R.drawable.photo1);
        }
        else if(photo == 2){
            imageView.setImageResource(R.drawable.photo2);
        }
        else if(photo == 3){
            imageView.setImageResource(R.drawable.photo3);
        }
        else if(photo == 4){
            imageView.setImageResource(R.drawable.photo4);
        }
    }
    public void begin(View view){
        Intent intent1 = new Intent();
        //切换到计时升级页面
        intent1.setClass(MainActivity4.this, MainActivity7.class);
        startActivity(intent1);
    }

    public void beginbattle(View view){
        Intent intent2 = new Intent();
        //切换到战斗页面
        intent2.setClass(MainActivity4.this, MainActivity8.class);
        startActivity(intent2);
    }

    public void click1(View view)  {
        index = time;
        name = MainActivity3.getName();
        View popupView = getLayoutInflater().inflate(R.layout.popup_window, null);
        TextView t0 = popupView.findViewById(R.id.text);
        TextView t1 = popupView.findViewById(R.id.text1);
        TextView t2 = popupView.findViewById(R.id.text2);
        TextView t3 = popupView.findViewById(R.id.text3);
        TextView t4 = popupView.findViewById(R.id.text4);
        TextView t5 = popupView.findViewById(R.id.text5);
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.showAsDropDown(view);//弹出PopupView

        grade = userRole.grade;
        Name = userRole.name;
        Hp = userRole.HP;
        atk = userRole.atk;
        defend = userRole.defend;
        exe = userRole.exe;

        FileHelper fileHelper = new FileHelper(MainActivity4.this);

        try{
            t0.setText(fileHelper.read("name.txt"));
            t2.setText(fileHelper.read("HP.txt"));
            t4.setText(fileHelper.read("defend.txt"));
            t3.setText(fileHelper.read("atk.txt"));
            t1.setText(fileHelper.read("grade.txt"));
            t5.setText(fileHelper.read("exe.txt"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static int gethp(){
        return Hp;
    }

    public static int getatk(){
        return atk;
    }
    public static int getdefend(){
        return defend;
    }
    public static int getgrade(){
        return grade;
    }
    public static int getexe(){
        return exe;
    }
    public  static String getname(){
        return Name;
    }
    public static Role getrole(){
        return userRole;
    }
}

