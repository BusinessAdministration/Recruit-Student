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

import com.example.recruit_student.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 范晋炜 on 2017/10/14 0014.
 * com.example.recruit_student.view.fragment
 * Infrom_fragment
 * 通知
 */


public class Infrom_fragment extends Fragment{

    @BindView(R.id.btn_fasong)
    Button btnFasong;
    @BindView(R.id.btn_jieshou)
    Button btnJieshou;
    Unbinder unbinder;
    private Infrom_fasong_fragment fasongFragment;
    private Infrom_shoudao_fragment shoudaoFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.infrom, null);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragment();
    }

    private void initFragment() {
        fasongFragment = new Infrom_fasong_fragment();
        shoudaoFragment = new Infrom_shoudao_fragment();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.infrom_framelayout, fasongFragment);
        transaction.add(R.id.infrom_framelayout, shoudaoFragment);
        transaction.show(fasongFragment);
        transaction.hide(shoudaoFragment);
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_fasong, R.id.btn_jieshou})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_fasong:
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.show(fasongFragment);
                transaction.hide(shoudaoFragment);
                transaction.commit();
                break;
            case R.id.btn_jieshou:
                FragmentManager manager2 = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction2 = manager2.beginTransaction();
                transaction2.hide(fasongFragment);
                transaction2.show(shoudaoFragment);
                transaction2.commit();
                break;
        }
    }



}
