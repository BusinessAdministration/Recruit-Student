package com.example.recruit_student.presenter;

import android.content.Context;

import com.example.recruit_student.app.MyApplication;
import com.example.recruit_student.view.IView;

/**
 * Created by 范晋炜 on 2017/10/14 0014.
 * com.example.recruit_student.presenter
 * IPresenter
 */


public class IPresenter<T extends IView> {
    protected T view;

    public IPresenter(T view) {
        this.view = view;
        init();
    }

    protected void init(){

    }

    public Context context(){
        if(view != null && view.context() != null){
            return view.context();
        }
        return MyApplication.context();
    }

}
