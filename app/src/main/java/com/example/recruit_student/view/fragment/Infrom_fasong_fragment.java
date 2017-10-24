package com.example.recruit_student.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.recruit_student.R;
import com.example.recruit_student.view.adapter.InfromRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 范晋炜 on 2017/10/23 0023.
 * com.example.recruit_student.view.fragment
 * Infrom_fasong_fragment
 * 发送通知
 */


public class Infrom_fasong_fragment extends Fragment {

    @BindView(R.id.infrom_recyclerview)
    RecyclerView infromRecyclerview;
    Unbinder unbinder;
    @BindView(R.id.btn_fasong)
    Button btnFasong;
    @BindView(R.id.btn_zuijifasong)
    Button btnZuijifasong;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.infrom_fasong_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        infromRecyclerview.setLayoutManager(linearLayoutManager);
        InfromRecyclerAdapter infromRecyclerAdapter = new InfromRecyclerAdapter();
        infromRecyclerview.setAdapter(infromRecyclerAdapter);
        infromRecyclerAdapter.setOnItemClickListener(new InfromRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(), "区域经理" + position + "被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_fasong, R.id.btn_zuijifasong})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_fasong:
                Toast.makeText(getActivity(), "发送成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_zuijifasong:
                Toast.makeText(getActivity(), "发送成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
