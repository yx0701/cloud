package com.yx.auth.controller;

import com.yx.auth.entity.user.ShiroUser;
import com.yx.auth.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CahceController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/getUser")
    public ShiroUser getUser(String userName){
        return cacheService.getUser(userName);
    }

    @GetMapping("/getUserCount")
    public Integer getUserCount(){
        System.out.println("getUserCount 从数据库获取");
        return cacheService.getUserCount();
    }
}
