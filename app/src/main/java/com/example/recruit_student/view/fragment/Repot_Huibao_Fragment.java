package com.example.recruit_student.view.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.recruit_student.R;
import com.example.recruit_student.view.activity.ReprotActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 范晋炜 on 2017/10/23 0023.
 * com.example.recruit_student.view.fragment
 * Repot_Huibao_Fragment
 */


public class Repot_Huibao_Fragment extends Fragment {

    private final String[] types = {"咨询", "讲座", "招聘", "出差", "家访", "帮扶"};

    @BindView(R.id.rihuibao)
    Button rihuibao;
    @BindView(R.id.lihuihuibao)
    Button lihuihuibao;
    @BindView(R.id.huodonghuibao)
    Button huodonghuibao;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.activity_repot__huibao__fragment, null);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rihuibao, R.id.lihuihuibao, R.id.huodonghuibao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rihuibao:
                showDialog();
                break;
            case R.id.lihuihuibao:
                Intent intent1 = new Intent(getActivity(),ReprotActivity.class);
                intent1.putExtra("title",lihuihuibao.getText());
                intent1.putExtra("type","会议");
                startActivity(intent1);
                break;
            case R.id.huodonghuibao:
                Intent intent2 = new Intent(getActivity(),ReprotActivity.class);
                intent2.putExtra("title",huodonghuibao.getText());
                intent2.putExtra("type","会议");
                startActivity(intent2);
                break;
        }
    }

    private void showDialog() {
        new AlertDialog.Builder(getContext())
                .setTitle("请选择日汇报的类型")
                .setSingleChoiceItems(types, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        String type = types[which];
                        Intent intent = new Intent(getActivity(), ReprotActivity.class);
                        intent.putExtra("title", rihuibao.getText());
                        intent.putExtra("type", type);
                        startActivity(intent);
                    }
                }).show();
    }
}
