package com.reizx.easyws;

import com.google.common.eventbus.AsyncEventBus;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EventBusUtil {
    private static AsyncEventBus asyncEventBus;

    public static void register(Object listener) {
        getAsyncEventBus().register(listener);
    }

    public static void post(Object event) {
        getAsyncEventBus().post(event);
    }

    private static AsyncEventBus getAsyncEventBus() {
        if (asyncEventBus == null) {
            asyncEventBus = new AsyncEventBus(executor());
        }
        return asyncEventBus;
    }


    private static ThreadPoolExecutor executor() {
        return new ThreadPoolExecutor(2,
                10,
                10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10));
    }
}
