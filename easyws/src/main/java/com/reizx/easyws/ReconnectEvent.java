package com.reizx.easyws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.java_websocket.client.WebSocketClient;

/**
 * 重连事件
 */
@Data
@AllArgsConstructor
class ReconnectEvent {
    @NonNull
    private WebSocketClient ws;
    @NonNull
    private int maxRetry;
}
