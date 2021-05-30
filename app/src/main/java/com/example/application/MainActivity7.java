package com.example.application;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity7 extends Activity implements PatternLockLayout.OnPatternStateListener
{
    private TextView tvInfo;
    private PatternLockLayout lockLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        tvInfo = (TextView) findViewById(R.id.txt_patternlock_info);
        tvInfo.setText("请设置闭关路线");
        lockLayout = (PatternLockLayout) findViewById(R.id.layout_lock);
        lockLayout.setOnPatternStateListener(this);
    }


    @Override
    public void onFinish(String password, int sizeOfPoints)
    {
        if(sizeOfPoints<5)
        {
            tvInfo.setText("请连接至少5个点");
            lockLayout.setAllSelectedPointsError();
        }
        else if( !password.equals("1235789") )
        {
            tvInfo.setText("运气路线错误");
            lockLayout.setAllSelectedPointsError();
        }
        else
        {
            tvInfo.setText("设置成功");
            Intent intent = new Intent();
            intent.setClass(MainActivity7.this, MainActivity5.class);
            startActivity(intent);
        }
    }

    @Override
    public void onReset()
    {
        tvInfo.setText("请设置闭关路线");
    }
}
