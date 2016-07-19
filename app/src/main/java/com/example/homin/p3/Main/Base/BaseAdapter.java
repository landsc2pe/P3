package com.example.homin.p3.Main.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p3.R;

/**
 * Created by HOMIN on 2016-07-15.
 */
abstract public class BaseAdapter extends RecyclerView.Adapter<ViewHolder> {
    public String TAG = getClass().getSimpleName();

    public interface OnItemClickListener {
        void onClick(int position);
    }

    abstract public void setOnItemClickListener(OnItemClickListener listener);

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_item, parent, false);

        return new ViewHolder(view);
    }
}
