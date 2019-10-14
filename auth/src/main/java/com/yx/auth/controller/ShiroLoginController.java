package com.yx.auth.controller;

import com.yx.auth.entity.JsonData;
import com.yx.auth.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ShiroLoginController {

    @GetMapping("/pub/need_login")
    public JsonData login(String userName,String password){

        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);

            subject.login(usernamePasswordToken);

            return JsonData.buildSuccess((String) subject.getSession().getId());

        }catch (Exception e){
            e.printStackTrace();

            return JsonData.buildError();

        }


    }
}