package com.yx.demo.controller;

import com.yx.demo.dao.UserMapper;
import com.yx.demo.entity.User;
import com.yx.demo.exception.MyException;
import com.yx.demo.service.AsyncTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Slf4j是日志框架的抽象   logback和log4j是日志框架实现    Slf4j需要结合后面两者使用  springboot2.0 默认使用slf4j+logback
@RestController
@Slf4j
public class TestController {

    @Value("${myTest}")
    String myTest;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AsyncTask asyncTask;

    @ApiOperation("tkTest方法")
    @GetMapping("/tkTest")
    public List tkTest(){
        User user = new User();
        user.setMyname("aaa");
        System.out.println(user.getMyname());
        return userMapper.selectAll();
    }

    @GetMapping("/testAsync")
    public String testAsync(){
        System.out.println(myTest);
        asyncTask.sleep();

        return "ok";
    }


    @GetMapping("/log")
    public void log(){
        log.trace("-----------trace-----------");
        log.debug("-----------debug-----------");
        log.info("-----------info-----------");
        log.warn("-----------warn-----------");
        log.error("-----------error-----------");
    }

    @GetMapping("/error1")
    public void error1() throws MyException {
//        int i = 9 / 0;
        throw new MyException();
    }

    @ApiOperation("创建用户")
    @GetMapping("/buildUser")
    public User buildUser(){
        User user = new User().name("bbb").password("123").build();
        return user;
    }

}
