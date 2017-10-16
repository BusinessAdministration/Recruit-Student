package com.example.recruit_student.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by 范晋炜 on 2017/10/14 0014.
 * com.example.recruit_student.app
 * MyApplication
 */


public class MyApplication extends Application{

    private static MyApplication myContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.myContext = this;
    }

    public static Context context(){
        return context();
    }

}
