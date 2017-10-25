package com.example.recruit_student.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.recruit_student.R;
import com.example.recruit_student.utils.WangluoUtil;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

/**
 * Created by 范晋炜 on 2017/10/14 0014.
 * com.example.recruit_student.view.fragment
 * Punch_card_fragment
 * 打卡
 */

//张庆龄打卡地图定位
public class Punch_card_fragment extends Fragment implements View.OnClickListener {

    private boolean canlocation;
    private TextView dingwei;
    public MyLocationListenner myListener = new MyLocationListenner();
    private LocationClientOption option;
    private LocationClient mLocationClient;
    private ImageView image_view;
    private TextView text_view;
    private Button gongzuo;
    private Button chuchai;
    private EditText ed_text;
    private Button tijiao;
    private String str;
    private String beizhu;
    private String weizhi;
    private TextView shezhi;
    private StyleableToast styleableToast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.punch_card, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListener();
    }

    // TODO: 2017/10/25 配置启动定位
    private void setListener() {
        mLocationClient = new LocationClient(getActivity());
        mLocationClient.registerLocationListener(myListener);
        option = new LocationClientOption();
        //设置获得地址位置
        option.setIsNeedAddress(true);
        //设置获得poi
        option.setIsNeedLocationPoiList(true);
        // 打开gps
        option.setOpenGps(true);
        // 设置坐标类型
        option.setCoorType("bd09ll");
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    // TODO: 2017/10/25 打卡信息
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gongzuo:
                    beizhu = ed_text.getText().toString().trim();
                if (TextUtils.isEmpty(beizhu)){
                    StyleableToast.makeText(getActivity(), "请输入打卡信息",Toast.LENGTH_LONG, R.style.StyleableToast).show();
               }else{
                    StyleableToast.makeText(getActivity(), "您在"+weizhi+"地区工作打卡成功,备注"+beizhu,Toast.LENGTH_SHORT, R.style.StyleableToast).show();
                    ed_text.setText("");
                }
                break;
            case R.id.chuchai:
                if (TextUtils.isEmpty(beizhu)) {
                    StyleableToast.makeText(getActivity(), "请输入打卡信息",Toast.LENGTH_LONG, R.style.StyleableToast).show();
                }else {
                    StyleableToast.makeText(getActivity(), "您在"+weizhi+"地区出差打卡成功,备注"+beizhu,Toast.LENGTH_SHORT, R.style.StyleableToast).show();
                    ed_text.setText("");
                }
                break;

        }
    }

    // TODO: 2017/10/25 得到您当前的位置，判断网络
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            if (WangluoUtil.isConnection(getActivity())){
                str = "您当前的位置：" + location.getAddress().address + ",纬度：" + location.getLatitude();
                weizhi = location.getAddress().address;
                dingwei.setText(str);

            }else {
                dingwei.setText("请打开网络完成定位");
                shezhi.setText("网络连接错误，请您检查网络设置        >");
                shezhi.setBackgroundColor(Color.parseColor("#e24747"));
                shezhi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                    }
                });
            }

        }
    }

    // TODO: 2017/10/25 得到ID
    private void initView(View view) {
        dingwei = (TextView) view.findViewById(R.id.text_view);
        gongzuo = (Button) view.findViewById(R.id.gongzuo);
        ed_text = (EditText) view.findViewById(R.id.ed_text);
        shezhi = (TextView) view.findViewById(R.id.shezhi);
        shezhi.setOnClickListener(this);
        gongzuo.setOnClickListener(this);
        chuchai = (Button) view.findViewById(R.id.chuchai);
        chuchai.setOnClickListener(this);
    }

}

