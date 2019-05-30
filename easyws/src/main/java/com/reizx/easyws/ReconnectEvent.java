package com.reizx.easyws;

import lombok.Data;
import org.java_websocket.client.WebSocketClient;

/**
 * 重连事件
 */
@Data
class ReconnectEvent {
    WebSocketClient ws;
}
