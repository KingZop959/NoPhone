package com.example.application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import javax.security.auth.login.LoginException;

public class MainActivity2 extends AppCompatActivity {

    public EditText editText2;
    public EditText editText3;
    public static String editStr1;
    public String editStr2;
    public String editStr3;
    public String nametext;
    public String pswtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText2 = (EditText) findViewById(R.id.text_userid);
        editText3 = (EditText) findViewById(R.id.text_userpwd);
    }

    public void click(View view) {

        FileHelper fileHelper = new FileHelper(MainActivity2.this);

        Bundle bundle = getIntent().getExtras();
        nametext = bundle.getString("ID");
        pswtext = bundle.getString("password");
        editStr2 = editText2.getText().toString();
        editStr3 = editText3.getText().toString();

        try {
            if (editStr2.equals(fileHelper.read("ID.txt")) && editStr3.equals(fileHelper.read("Password.txt"))) {
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity2.this, MainActivity4.class);
                startActivity(intent1);
            } else {
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_view1, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(R.drawable.ic_failed_24)
                        .setTitle("登录错误")
                        .setView(dialogView)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                intent.setClass(MainActivity2.this, MainActivity2.class);
                                startActivity(intent);
                            }
                        })
                        .create()//创建对话框
                        .show();//显示对话框
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}