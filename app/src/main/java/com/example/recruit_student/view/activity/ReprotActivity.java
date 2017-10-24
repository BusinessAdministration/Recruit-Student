package com.example.recruit_student.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recruit_student.R;

import java.util.ArrayList;

/**
 * Created by 北城 on 2017/10/24.
 */

public class ReprotActivity extends AppCompatActivity implements View.OnClickListener {

    private final String[] types = {"咨询", "讲座", "招聘", "出差", "家访", "帮扶", "会议"};

    private final String[] type0 = {"学生姓名:", "学生联系电话:", "性别:", "效果:", "证明人及联系电话:", "接待人电话:", "备注:"};
    private final String[] type1 = {"参加人数:", "地点:", "效果:", "证明人及联系电话:", "讲座人电话:", "备注:"};
    private final String[] type2 = {"参加人数:", "地点:", "效果:", "证明人及联系电话:", "招聘主管人电话:", "备注:"};
    private final String[] type3 = {"需用时长:", "地点:", "目的:", "证明人及联系电话:", "主管人电话:", "备注:"};
    private final String[] type4 = {"家长姓名:", "家长联系电话:", "学生姓名:", "效果:", "证明人及联系电话:", "负责家访领导电话:", "备注:"};
    private final String[] type5 = {"地点:", "具体内容:", "效果:", "证明人及联系电话:", "帮扶总领导电话:", "备注:"};
    private final String[] type6 = {"参加人数:", "地点:", "具体内容:", "效果:", "证明人及联系电话:", "会议主持人电话:", "备注:"};
    private ArrayList<String[]> list;
    private TextView title;
    private EditText content0;
    private EditText content1;
    private EditText content2;
    private EditText content3;
    private EditText content4;
    private EditText content5;
    private EditText content6;
    private TextView name0;
    private TextView name1;
    private TextView name2;
    private TextView name3;
    private TextView name4;
    private TextView name5;
    private TextView name6;
    private LinearLayout layout6;
    private String[] strings;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activityrepot);
        initView();
        String title = getIntent().getStringExtra("title");
        String type = getIntent().getStringExtra("type");
        this.title.setText(title + "--" + type);
        for (int i = 0; i < types.length; i++) {
            if (type.equals(types[i])) {
                strings = list.get(i);
            }
        }

        if (strings.length == types.length - 1) {
            layout6.setVisibility(View.GONE);
            name0.setText(strings[0]);
            name1.setText(strings[1]);
            name2.setText(strings[2]);
            name3.setText(strings[3]);
            name4.setText(strings[4]);
            name5.setText(strings[5]);
        }else if(strings.length == types.length){
            layout6.setVisibility(View.VISIBLE);
            name0.setText(strings[0]);
            name1.setText(strings[1]);
            name2.setText(strings[2]);
            name3.setText(strings[3]);
            name4.setText(strings[4]);
            name5.setText(strings[5]);
            name6.setText(strings[6]);
        }

    }

    private void initView() {
        list = new ArrayList<>();
        list.add(type0);
        list.add(type1);
        list.add(type2);
        list.add(type3);
        list.add(type4);
        list.add(type5);
        list.add(type6);
        Button commit = (Button) findViewById(R.id.commit);
        Button gouback = (Button) findViewById(R.id.gouBack);
        commit.setOnClickListener(this);
        gouback.setOnClickListener(this);
        title = (TextView) findViewById(R.id.biaoti);
        content0 = (EditText) findViewById(R.id.content0);
        content1 = (EditText) findViewById(R.id.content1);
        content2 = (EditText) findViewById(R.id.content2);
        content3 = (EditText) findViewById(R.id.content3);
        content4 = (EditText) findViewById(R.id.content4);
        content5 = (EditText) findViewById(R.id.content5);
        content6 = (EditText) findViewById(R.id.content6);

        name0 = (TextView) findViewById(R.id.name0);
        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView) findViewById(R.id.name2);
        name3 = (TextView) findViewById(R.id.name3);
        name4 = (TextView) findViewById(R.id.name4);
        name5 = (TextView) findViewById(R.id.name5);
        name6 = (TextView) findViewById(R.id.name6);

        layout6 = (LinearLayout) findViewById(R.id.layout6);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.commit:
                String s = commitContent();
                if(!(TextUtils.isEmpty(s))){
                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.gouBack:
                finish();
                break;
        }

    }

    private String commitContent() {
        String content = null;
        if(strings.length == types.length-1){
            String text0 = content0.getText().toString().trim();
            String text1 = content1.getText().toString().trim();
            String text2 = content2.getText().toString().trim();
            String text3 = content3.getText().toString().trim();
            String text4 = content4.getText().toString().trim();
            String text5 = content5.getText().toString().trim();
            if(TextUtils.isEmpty(text0) || TextUtils.isEmpty(text1) || TextUtils.isEmpty(text2)|| TextUtils.isEmpty(text3) || TextUtils.isEmpty(text4)){
                Toast.makeText(this, "输入内容不能为空!", Toast.LENGTH_SHORT).show();
            }else {
                content = text0 + "," + text1 + "," + text2 + "," + text3 + "," + text4 + "," + text5;
            }
        }else  if(strings.length == types.length){
            String text0 = content0.getText().toString().trim();
            String text1 = content1.getText().toString().trim();
            String text2 = content2.getText().toString().trim();
            String text3 = content3.getText().toString().trim();
            String text4 = content4.getText().toString().trim();
            String text5 = content5.getText().toString().trim();
            String text6 = content6.getText().toString().trim();
            if (TextUtils.isEmpty(text0) || TextUtils.isEmpty(text1) || TextUtils.isEmpty(text2) || TextUtils.isEmpty(text3) || TextUtils.isEmpty(text4) || TextUtils.isEmpty(text5)) {
                Toast.makeText(this, "输入内容不能为空!", Toast.LENGTH_SHORT).show();
            } else {
                content = text0 + "," + text1 + "," + text2 + "," + text3 + "," + text4 + "," + text5 + "," + text6;
            }
        }
        return content;
    }
}
