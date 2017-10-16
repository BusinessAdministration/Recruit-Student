package com.example.recruit_student.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.recruit_student.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 范晋炜 on 2017/10/14 0014.
 * com.example.recruit_student.view.activity
 * GuidePageActivity
 */


public class GuidePageActivity extends AppCompatActivity{

    private Timer timer;
    private TextView tvBreak;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //显示当前页面布局
        setContentView(R.layout.activity_guide_page);
        tvBreak = (TextView) findViewById(R.id.tv_break);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            int time=5;
            @Override
            public void run() {
                if (time!=0){
                    time--;
                }else{
                    Intent intent = new Intent(GuidePageActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },0,1000);

        //设置跳过的监听事件
        tvBreak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuidePageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer!=null){
            //关闭timer
            timer.cancel();
        }
    }
}
