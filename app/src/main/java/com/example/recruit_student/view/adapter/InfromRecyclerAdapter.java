package com.example.recruit_student.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.recruit_student.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 范晋炜 on 2017/10/24 0024.
 * com.example.recruit_student.view.adapter
 * InfromRecyclerAdapter
 */


public class InfromRecyclerAdapter extends RecyclerView.Adapter{
    private List<String> list;

    public InfromRecyclerAdapter() {
        list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add("区域经理" + i);
        }
    }
    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.infrom_recyclerview_item, parent, false);
        MyViewholder myViewholder = new MyViewholder(view);
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final MyViewholder holder1= (MyViewholder) holder;
        holder1.textView.setText(list.get(position));
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItemClick(position);
                    if (holder1.checkBox.isChecked()){
                        holder1.checkBox.setChecked(false);
                    }else{
                        holder1.checkBox.setChecked(true);
                    }

                }
            }
        });
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private View itemView;
        private final CheckBox checkBox;

        public MyViewholder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.infrom_recyclerview_item_text);
            checkBox = (CheckBox) itemView.findViewById(R.id.infrom_recyclerview_item_checkBox);
            this.itemView=itemView;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
