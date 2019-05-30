package com.reizx.easyws;

import com.google.common.eventbus.Subscribe;

class ReconnectListener {
    @Subscribe
    private void reconnect(ReconnectEvent event) {
        try {
            if (event.getWs() != null || !event.getWs().isOpen()) {//当ws存在但是状态为端口连接的时候进行重连
                //
                // 此处有必要做一个说明
                // 每一次event.getWs().reconnectBlocking();失败的时候都会调用刚到onClose()处，因此可以形成一个循环。
                event.getWs().reconnectBlocking();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
