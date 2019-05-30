# EasyWs
a simple lib for websocket base on [Java-WebSocket](https://github.com/TooTallNate/Java-WebSocket), that can auto reconnect.


# how to use it ?

```
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
            try {
                ws.send(" hello..");
            }catch (Exception ignored){
            }
            Thread.sleep(5000);
        }
    }
}
```
You can extend  `EasyWs`. 
