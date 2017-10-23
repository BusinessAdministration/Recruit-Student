package com.example.recruit_student.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.recruit_student.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 范晋炜 on 2017/10/14 0014.
 * com.example.recruit_student.view.fragment
 * Repot_fragment
 * 汇报
 */


public class Repot_fragment extends Fragment{

    @BindView(R.id.huibao)
    Button huibao;
    @BindView(R.id.chaxunhuibao)
    Button chaxunhuibao;
    @BindView(R.id.huibao_fragment)

    FrameLayout huibaoFragment;
    Unbinder unbinder;
    private Fragment[] fragments;
    private int mIndex = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.repot, null);
        unbinder = ButterKnife.bind(this, v);
        initFragment();
        return v;
    }

    private void initFragment() {
        Repot_Huibao_Fragment rhb = new Repot_Huibao_Fragment();
        Repot_Chaxunhuibao_Fragment rcxhb = new Repot_Chaxunhuibao_Fragment();
        fragments = new Fragment[]{rhb,rcxhb};
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.huibao_fragment,rhb).commit();
        setFragmentHideOrShow(0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.huibao, R.id.chaxunhuibao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.huibao:
                setFragmentHideOrShow(0);
                break;
            case R.id.chaxunhuibao:
                setFragmentHideOrShow(1);
                break;
        }
    }

    private void setFragmentHideOrShow(int index) {
        if (mIndex == index) {
            return;
        }
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        //隐藏
        ft.hide(fragments[mIndex]);
        //判断是否添加
        if (!fragments[index].isAdded()) {
            ft.add(R.id.huibao_fragment, fragments[index]).show(fragments[index]);
        } else {
            ft.show(fragments[index]);
        }
        ft.commit();
        //再次赋值
        mIndex = index;
    }
}
