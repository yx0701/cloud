package com.yx.auth.websocket;

import java.io.IOException;

public class TestTask implements Runnable{
    @Override
    public void run() {
        while(true) {
            try {
                WebSocketServer.sendInfo("message1", "ff");
                Thread.sleep(2000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
