package com.example.recruit_student.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recruit_student.R;

/**
 * Created by 范晋炜 on 2017/10/14 0014.
 * com.example.recruit_student.view.fragment
 * Repot_fragment
 * 汇报
 */


public class Repot_fragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.repot,container,false);
        return view;
    }
}
