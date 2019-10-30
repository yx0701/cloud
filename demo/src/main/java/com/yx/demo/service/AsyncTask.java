package com.yx.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {

    @Async("scorePoolTaskExecutor")
    public void sleep(){
        try {
            Thread.sleep(4000);
            System.out.println("sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
