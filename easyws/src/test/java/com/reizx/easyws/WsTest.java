package com.reizx.easyws;

import org.java_websocket.handshake.ServerHandshake;
import org.junit.Test;

import java.net.URISyntaxException;

public class WsTest {
    @Test
    public void test() throws URISyntaxException, InterruptedException {
        EasyWs ws = new EasyWs("ws://127.0.0.1:8086/socketServer/testxxx") {
            @Override
            public void open(ServerHandshake handshakedata) {
                System.out.println("open connection ");
            }

            @Override
            public void message(String message) {
                System.out.println("get the msg : " + message);
            }

            @Override
            public void close(int code, String reason, boolean remote) {
                System.out.println("close connection ");
            }

            @Override
            public void error(Exception ex) {
                System.out.println("ws exception : " + ex);
            }
        };

        ws.connectBlocking();
        while (true){
            Thread.sleep(1000);
        }
//        Thread.sleep(3 * 60 * 1000);
    }
}
