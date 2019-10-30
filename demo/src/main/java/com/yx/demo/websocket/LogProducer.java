package com.yx.demo.websocket;

//@Component
public class LogProducer implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while(true){
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LogConsumer.concurrentLinkedQueue.add("log " + i);
            i++;
        }
    }
}
