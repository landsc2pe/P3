package com.example.homin.p3.Main;

import android.view.View;

import com.example.homin.p3.Main.base.BaseAdapter;
import com.example.homin.p3.Main.base.ViewHolder;

import java.util.List;

/**
 * Created by HOMIN on 2016-07-15.
 */
public class MainAdapter extends BaseAdapter {

    private List<String> item;
    private OnItemClickListener onItemClickListener;

    public MainAdapter(List item) {
        this.item = item;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemView.setText(item.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }
}
