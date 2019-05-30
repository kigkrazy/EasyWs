package com.reizx.easyws;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Map;

public abstract class EasyWs extends WebSocketClient {
    public EasyWs(URI serverUri) {
        super(serverUri);
    }

    public EasyWs(URI serverUri, Draft protocolDraft) {
        super(serverUri, protocolDraft);
    }

    public EasyWs(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
    }

    public EasyWs(URI serverUri, Draft protocolDraft, Map<String, String> httpHeaders) {
        super(serverUri, protocolDraft, httpHeaders);
    }

    public EasyWs(URI serverUri, Draft protocolDraft, Map<String, String> httpHeaders, int connectTimeout) {
        super(serverUri, protocolDraft, httpHeaders, connectTimeout);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        close(code, reason, remote);
        EventBusUtil.post(new ReconnectEvent(this));//发射post重启命令
    }

    @Override
    public void onError(Exception exception) {
        error(exception);
    }

    @Override

    public void onMessage(String message) {
        message(message);
    }

    @Override

    public void onOpen(ServerHandshake arg0) {
        open(arg0);
    }

    // ABTRACT METHODS /////////////////////////////////////////////////////////
    public abstract void open(ServerHandshake handshakedata);

    public abstract void message(String message);

    public abstract void close(int code, String reason, boolean remote);

    public abstract void error(Exception ex);
}
