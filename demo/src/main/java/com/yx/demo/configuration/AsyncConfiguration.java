package com.yx.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync  //也可以写在主类中
@Configuration
public class AsyncConfiguration {

    @Bean(name = "scorePoolTaskExecutor")
    public ThreadPoolTaskExecutor getScorePoolTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //核心线程数
        taskExecutor.setCorePoolSize(10);
        //线程池维护最大数量，只有在缓冲队列满了之后才会申请超过核心线程的数量
        taskExecutor.setMaxPoolSize(100);
        //缓存队列
        taskExecutor.setQueueCapacity(50);
        //允许的空闲时间，当超过了核心线程之外的线程在空闲时间达到之后会被销毁
        taskExecutor.setKeepAliveSeconds(200);
        //线程名
        taskExecutor.setThreadNamePrefix("score-");
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }

}
