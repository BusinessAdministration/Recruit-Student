package com.example.recruit_student.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recruit_student.R;
import com.example.recruit_student.app.MyApplication;
import com.example.recruit_student.utils.LocationClientUtils;
import com.example.recruit_student.utils.PermissionManager;

import static android.content.Context.MODE_PRIVATE;
import static com.example.recruit_student.view.activity.MainActivity.NETWORK_STATE_BOOLEAN;
import static com.example.recruit_student.view.activity.MainActivity.NETWORK_STATE_NAME;

/**
 * Created by 范晋炜 on 2017/10/14 0014.
 * com.example.recruit_student.view.fragment
 * Punch_card_fragment
 * 打卡
 */

public class Punch_card_fragment extends Fragment {

    private boolean canlocation;
    private ImageView image_view;
    private TextView dingwei;

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
        canlocation = PermissionManager.CanLocation(getActivity());
        newwork();
    }

    private void newwork() {
        if (canlocation) {
            boolean aBoolean = getActivity().getSharedPreferences(NETWORK_STATE_NAME, MODE_PRIVATE)
                    .getBoolean(NETWORK_STATE_BOOLEAN, false);
            if (aBoolean) {
                LocationClientUtils.getLocation(MyApplication.context());
                LocationClientUtils.setMyLocationListener(new LocationClientUtils.MyLocationListener() {
                    @Override
                    public void myLocatin(double mylongitude, double mylatitude, String province, String city, String street) {
                        dingwei.setText("您当前的位置是"+province+"--"+city+"--"+street);
                    }
                });
            }else {
                dingwei.setText("您的定位未开启");
            }
        }
    }

    private void initView(View view) {
        image_view = (ImageView) view.findViewById(R.id.image_view);
        dingwei = (TextView) view.findViewById(R.id.text_view);
    }
}
