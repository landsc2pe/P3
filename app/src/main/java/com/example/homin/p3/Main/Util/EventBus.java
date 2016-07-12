package com.example.homin.p3.Main.Util;

import com.squareup.otto.Bus;

/**
 * Created by jjkim on 2016. 7. 2..
 */
public class EventBus {
    static EventBus instance;
    Bus bus;

    private EventBus() {
        bus = new MainThreadBus();
    }

    public static EventBus getInstance() {
        if(instance == null) {  // DCL(Double Checked Locking)
            synchronized (EventBus.class) {
                if(instance == null)
                    instance = new EventBus();
            }
        }

        return instance;
    }

    public Bus getBus() {
        return bus;
    }
}
