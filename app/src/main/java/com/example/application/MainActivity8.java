package com.example.application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

public class MainActivity8 extends AppCompatActivity {

    ComUser comUser1 = new ComUser();
    ComUser comUser2 = new ComUser();
    ComUser comUser3 = new ComUser();

    private int Hp;
    private int Atk;
    private int Defend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        TextView t11 = findViewById(R.id.text11);
        TextView t12 = findViewById(R.id.text12);
        TextView t13 = findViewById(R.id.text13);
        TextView t14 = findViewById(R.id.text14);
        TextView t15 = findViewById(R.id.text15);
        TextView t21 = findViewById(R.id.text21);
        TextView t22 = findViewById(R.id.text22);
        TextView t23 = findViewById(R.id.text23);
        TextView t24 = findViewById(R.id.text24);
        TextView t25 = findViewById(R.id.text25);
        TextView t31 = findViewById(R.id.text31);
        TextView t32 = findViewById(R.id.text32);
        TextView t33 = findViewById(R.id.text33);
        TextView t34 = findViewById(R.id.text34);
        TextView t35 = findViewById(R.id.text35);

        t11.setText(String.valueOf(comUser1.name));
        t12.setText(String.valueOf(comUser1.grade));
        t13.setText(String.valueOf(comUser1.HP));
        t14.setText(String.valueOf(comUser1.atk));
        t15.setText(String.valueOf(comUser1.defend));
        t21.setText(String.valueOf(comUser2.name));
        t22.setText(String.valueOf(comUser2.grade));
        t23.setText(String.valueOf(comUser2.HP));
        t24.setText(String.valueOf(comUser2.atk));
        t25.setText(String.valueOf(comUser2.defend));
        t31.setText(String.valueOf(comUser3.name));
        t32.setText(String.valueOf(comUser3.grade));
        t33.setText(String.valueOf(comUser3.HP));
        t34.setText(String.valueOf(comUser3.atk));
        t35.setText(String.valueOf(comUser3.defend));

    }

    public void battle1(View view) {

        Hp = MainActivity4.gethp();
        Atk = MainActivity4.getatk();
        Defend = MainActivity4.getdefend();

        if(Atk - comUser1.defend >=comUser1.HP){
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_view3, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.ic_failed_24)
                    .setTitle("胜利！")
                    .setView(dialogView)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.setClass(MainActivity8.this, MainActivity4.class);
                            startActivity(intent);
                        }
                    })
                    .create()//创建对话框
                    .show();//显示对话框
        }
        else{
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_view4, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.ic_failed_24)
                    .setTitle("失败")
                    .setView(dialogView)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.setClass(MainActivity8.this, MainActivity4.class);
                            startActivity(intent);
                        }
                    })
                    .create()//创建对话框
                    .show();//显示对话框
        }
    }

    public void battle2(View view) {

        Hp = MainActivity4.gethp();
        Atk = MainActivity4.getatk();
        Defend = MainActivity4.getdefend();

        if(comUser2.atk - Defend >= Hp){
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_view4, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.ic_failed_24)
                    .setTitle("失败")
                    .setView(dialogView)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.setClass(MainActivity8.this, MainActivity4.class);
                            startActivity(intent);
                        }
                    })
                    .create()//创建对话框
                    .show();//显示对话框
        }
        else{
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_view3, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.ic_failed_24)
                    .setTitle("胜利！")
                    .setView(dialogView)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.setClass(MainActivity8.this, MainActivity4.class);
                            startActivity(intent);
                        }
                    })
                    .create()//创建对话框
                    .show();//显示对话框
        }
    }

    public void battle3(View view) {

        Hp = MainActivity4.gethp();
        Atk = MainActivity4.getatk();
        Defend = MainActivity4.getdefend();

        if(Atk - comUser3.defend >=comUser3.HP){
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_view3, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.ic_failed_24)
                    .setTitle("胜利!")
                    .setView(dialogView)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.setClass(MainActivity8.this, MainActivity4.class);
                            startActivity(intent);
                        }
                    })
                    .create()//创建对话框
                    .show();//显示对话框
        }
        else{
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_view4, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.ic_failed_24)
                    .setTitle("失败")
                    .setView(dialogView)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.setClass(MainActivity8.this, MainActivity4.class);
                            startActivity(intent);
                        }
                    })
                    .create()//创建对话框
                    .show();//显示对话框
        }
    }
}