package com.yx.demo.controller;

import com.yx.demo.entity.JsonData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class ShiroLoginController {

    @PostMapping("/pub/need_login")
    public JsonData login(@RequestBody Map<String,String> map) {
        String userName = map.get("userName");
        String password = map.get("password");
        if(userName ==null || password == null){
            return JsonData.buildError();
        }

        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);

            subject.login(usernamePasswordToken);

            return JsonData.buildSuccess((String) subject.getSession().getId());

        } catch (Exception e) {
            e.printStackTrace();

            return JsonData.buildError();

        }


    }


    @RequestMapping("/logout")
    public JsonData findMyPlayRecord() {

        Subject subject = SecurityUtils.getSubject();

//        if (subject.getPrincipals() != null) {
//        }

        SecurityUtils.getSubject().logout();

        return JsonData.buildSuccess("logout成功");

    }
}