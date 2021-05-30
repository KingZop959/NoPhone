package com.example.application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    Chronometer ch ;
    Button bt1;
    public EditText editText1;
    public EditText editText2;
    public EditText editText3;
    public String editStr1;
    public String editStr2;
    public static String editStr3;
    public static int photo = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ch = (Chronometer) findViewById(R.id.test);
        bt1 = (Button) findViewById(R.id.button1);
        editText1 = (EditText)findViewById(R.id.text_userid);
        editText2 = (EditText)findViewById(R.id.text_userpwd);
        bt1.setOnClickListener(new View.OnClickListener() {

            Random ra = new Random();
           int a = ra.nextInt(10);
           int b = ra.nextInt(10);
           int c = ra.nextInt(10);
           int d = ra.nextInt(10);
           int text =( a*1000 +b *100 + c * 10 + d * 1);
            @Override
            public void onClick(View v) {
                bt1.setText(String.valueOf(text));
                bt1.setEnabled(true);
            }
    });
    }

    public void click5(View view){

        editStr1 = editText1.getText().toString();
        editStr2 = editText2.getText().toString();

        View dialogView = getLayoutInflater().inflate(R.layout.dialog_view, null);
        ImageView imageView1 = dialogView.findViewById(R.id.photo1);
        ImageView imageView2 = dialogView.findViewById(R.id.photo2);
        ImageView imageView3 = dialogView.findViewById(R.id.photo3);
        ImageView imageView4 = dialogView.findViewById(R.id.photo4);
        editText3 = dialogView.findViewById(R.id.edittext1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photo = 1;
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photo = 2;
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photo = 3;
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photo = 4;
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_success)
                .setTitle("注册成功！请设置你的头像和玩家ID")
                .setView(dialogView)
                .setPositiveButton("去登陆", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editStr3 = editText3.getText().toString();
                        FileHelper fileHelper = new FileHelper(MainActivity3.this);
                        try {
                            fileHelper.save("ID.txt",editStr1);
                            fileHelper.save("Password.txt",editStr2);
                            fileHelper.save("name.txt",editStr3);
                            fileHelper.save("HP.txt","100");
                            fileHelper.save("defend.txt","10");
                            fileHelper.save("atk.txt","20");
                            fileHelper.save("grade.txt","0");
                            fileHelper.save("exe.txt","0");
                            fileHelper.save("sex.txt","0");
                            Log.e("abc", "onClick: "+fileHelper.read("HP.txt"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Log.e("abc", "你的昵称： " + editStr3);
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("ID",editStr1);
                        bundle.putString("password",editStr2);
                        intent.putExtras(bundle);
                        intent.setClass(MainActivity3.this, MainActivity2.class);
                        startActivity(intent);
                    }
                })
                .create()//创建对话框
                .show();//显示对话框

    }

    public static String getName(){
        return editStr3;
    }

    public static int getPhoto(){
        return photo;
    }

}