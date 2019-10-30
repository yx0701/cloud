package com.yx.websocket;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

//@Component
public class LogConsumer implements Runnable{
    public static ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    public static boolean flag = true;
    @Override
    public void run() {
        while(flag) {
            try {
                String info = concurrentLinkedQueue.poll();
                WebSocketServer.sendInfo(info, "ff");
                Thread.sleep(1);
//                Thread.sleep(1);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
