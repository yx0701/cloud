package com.yx.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication //该注解包含了以上三个注解
@MapperScan("com.yx.demo.dao")
//@EnableAsync
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
