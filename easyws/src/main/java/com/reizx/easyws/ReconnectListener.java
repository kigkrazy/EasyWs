package com.reizx.easyws;

import com.google.common.eventbus.Subscribe;

import java.util.Timer;
import java.util.TimerTask;

class ReconnectListener {
    @Subscribe
    private void reconnect(ReconnectEvent event) {
        Timer timer = new Timer();
        int retry = 0;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    if (retry >= event.getMaxRetry()){
                        timer.cancel();
                        return;
                    }

                    if (event.getWs() != null || !event.getWs().isOpen()) {
                        //当ws存在但是状态为端口连接的时候进行重连
                        event.getWs().reconnectBlocking();
                        return;
                    }
                    timer.cancel();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1000, 3000);
    }
}
