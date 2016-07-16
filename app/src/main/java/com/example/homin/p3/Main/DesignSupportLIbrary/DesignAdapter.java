package com.example.homin.p3.Main.DesignSupportLIbrary;

import android.util.Log;
import android.view.View;

import android.view.ViewGroup;
import com.example.homin.p3.Main.Base.BaseAdapter;
import com.example.homin.p3.Main.Base.Util.LogTag;
import com.example.homin.p3.Main.Base.ViewHolder;
import com.example.homin.p3.R;

import java.util.List;

/**
 * Created by HOMIN on 2016-07-15.
 */
public class DesignAdapter extends BaseAdapter {

    private final List<String> item;
    private OnItemClickListener onItemClickListener;

    public DesignAdapter(List<String> itemList) {
        item = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = super.onCreateViewHolder(parent, viewType);
        holder.itemView.setTextColor(
                parent.getContext().getResources().getColor(R.color.greenColor));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemView.setText(item.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    if(LogTag.DEBUG) Log.d(TAG, item.get(position));
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
