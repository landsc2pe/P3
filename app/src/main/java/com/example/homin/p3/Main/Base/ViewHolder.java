package com.example.homin.p3.Main.Base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.homin.p3.R;

/**
 * Created by HOMIN on 2016-07-15.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView itemView;

    public ViewHolder(View itemView) {
        super(itemView);

        this.itemView = (TextView) itemView.findViewById(R.id.mainItem);
    }
}
