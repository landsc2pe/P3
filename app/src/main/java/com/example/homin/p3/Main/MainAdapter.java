package com.example.homin.p3.Main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.homin.p3.R;

import java.util.List;

/**
 * Created by HOMIN on 2016-07-07.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<String> item;
    private OnItemClickListener onItemClickListener;

    public MainAdapter(List item) {
        this.item = item;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d("setText", item.get(position));
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


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemView;

        public ViewHolder(View itemView) {
            super(itemView);

            this.itemView = (TextView) itemView.findViewById(R.id.mainItem);
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}



