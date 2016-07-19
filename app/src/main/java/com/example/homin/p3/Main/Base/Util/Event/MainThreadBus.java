package com.example.homin.p3.Main.base.Util.Event;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * Created by jjkim on 2016. 7. 2..
 */
public class MainThreadBus extends Bus {
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event);
        } else {
            mHandler.post(new Runnable() {

                @Override
                public void run() {
                    MainThreadBus.super.post(event);
                }
            });
        }
    }
}

