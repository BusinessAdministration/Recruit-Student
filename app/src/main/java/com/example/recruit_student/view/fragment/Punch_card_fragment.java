package com.example.recruit_student.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.recruit_student.R;

/**
 * Created by 范晋炜 on 2017/10/14 0014.
 * com.example.recruit_student.view.fragment
 * Punch_card_fragment
 * 打卡
 */

//张庆龄打卡地图定位
public class Punch_card_fragment extends Fragment {

    private boolean canlocation;
    private TextView dingwei;
    public MyLocationListenner myListener = new MyLocationListenner();
    private LocationClientOption option;
    private LocationClient mLocationClient;

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

    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            String str = "您当前的位置："+location.getAddress().address+",纬度："+location.getLatitude();
            dingwei.setText(str);
        }
    }
    private void initView(View view) {
        dingwei = (TextView) view.findViewById(R.id.text_view);
    }
}
