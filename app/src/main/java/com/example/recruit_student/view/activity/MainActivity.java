package com.example.recruit_student.view.activity;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.recruit_student.R;
import com.example.recruit_student.view.fragment.Infrom_fragment;
import com.example.recruit_student.view.fragment.My_fragment;
import com.example.recruit_student.view.fragment.Punch_card_fragment;
import com.example.recruit_student.view.fragment.Repot_fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //保存网络状态的SharedPreferences()的名字
    public static final String NETWORK_STATE_NAME = "NETWORK_STATE_NAME";
    //保存是否有网络的boolean值
    public static final String NETWORK_STATE_BOOLEAN = "NETWORK_STATE_BOOLEAN";
    //跳转网络设置的请求码
    public static final int SET_NETWORK_REQUEST = 106;
    //id
    @BindView(R.id.main_framelayout)
    FrameLayout mainFramelayout;
    @BindView(R.id.punch_card)
    RadioButton punchCard;
    @BindView(R.id.repot)
    RadioButton repot;
    @BindView(R.id.infrom)
    RadioButton infrom;
    @BindView(R.id.my)
    RadioButton my;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    private FragmentManager manager;
    private Fragment[] fragments;
    private int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //主分支  master  第一次提交
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        initFragment();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                    if (radioButton.isChecked()) {
                        setFragmentHideOrShow(i);
                        radioButton.setTextColor(Color.RED);
                    }else {
                        radioButton.setTextColor(Color.BLACK);
                    }
                }
            }
        });
    }

    private void initFragment() {
        Punch_card_fragment punchCardFragment = new Punch_card_fragment();
        Repot_fragment repotFragment = new Repot_fragment();
        Infrom_fragment infromFragment = new Infrom_fragment();
        My_fragment myFragment = new My_fragment();
        //添加到数组
        fragments = new Fragment[]{punchCardFragment, repotFragment, infromFragment, myFragment};
        //开启事务
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //添加首页
        transaction.add(R.id.main_framelayout,punchCardFragment).commit();
        //默认设置第一个fragment显示
        setFragmentHideOrShow(0);
    }

    //显示隐藏fragment的方法
    private void setFragmentHideOrShow(int index) {
        if (mIndex == index) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        //隐藏
        ft.hide(fragments[mIndex]);
        //判断是否添加
        if (!fragments[index].isAdded()) {
            ft.add(R.id.main_framelayout, fragments[index]).show(fragments[index]);
        } else {
            ft.show(fragments[index]);
        }
        ft.commit();
        //再次赋值
        mIndex = index;
    }

}
