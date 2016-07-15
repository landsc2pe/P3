package com.example.homin.p3.Main.Base;

import android.support.v4.app.Fragment;

import com.example.homin.p3.Main.Base.Util.Event.EventBus;

/**
 * Created by HOMIN on 2016-07-15.
 */
public class BaseFragment extends Fragment {
    public String TAG = getClass().getSimpleName();


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        //EventBus Unregister
        EventBus.getInstance().getBus().unregister(this);
    }
}
