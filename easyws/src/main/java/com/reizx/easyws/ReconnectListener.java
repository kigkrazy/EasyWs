package com.reizx.easyws;

import com.google.common.eventbus.Subscribe;

class ReconnectListener {
    private final static ReconnectListener listener = new ReconnectListener();

    static {
        listener.register();
    }

    private void register() {
        EventBusUtil.register(this);
    }

    @Subscribe
    private void reconnect(ReconnectEvent event) {
        try {
            assert event.getWs() != null;
            if (event.getWs() != null || !event.getWs().isOpen()) {
                event.getWs().reconnectBlocking();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
