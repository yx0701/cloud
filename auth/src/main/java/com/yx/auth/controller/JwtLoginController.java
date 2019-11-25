package com.yx.auth.controller;

import com.yx.auth.dao.UserDao;
import com.yx.auth.entity.JsonData;
import com.yx.auth.entity.User;
import com.yx.auth.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/login")
@RestController
public class JwtLoginController {

    @Autowired
    private UserDao userDao;

    /**
     * 登录验证并生成jwt
     */
    @PostMapping("/jwtLogin")
    public JsonData jwtLogin(@RequestBody User user){
        //查数据库验证
        User userDB = userDao.login(new User(user.getName(),user.getPassword()));
        if(userDB == null){
            return new JsonData(JsonData.ERROR_CODE,"用户名或密码错误");
        }
        //生成jwt
        String token = JWTUtil.genJWT(user);
        return new JsonData(JsonData.SUCCESS_CODE,token);
    }

    /**
     * 验证jwt
     */
    @PostMapping("/validateToken")
    public JsonData validate(@RequestBody Map<String,String> map){
        String token = map.get("token");
        Claims claims;
        try {
            claims = JWTUtil.checkJWT(token);
        } catch (Exception e) {
            return new JsonData(-1,"token失效或不正确");
        }
        if(claims != null){
            String name = (String) claims.get("name");
            return new JsonData(JsonData.SUCCESS_CODE,"welcome "+ name);
        }
        return new JsonData(JsonData.ERROR_CODE,"未知错误");
    }

    @PostMapping("/validateReg")
    public JsonData validateReg(@RequestBody Map<String,String> map){
        String userName = map.get("userName");
        int count = userDao.validateReg(userName);
        return count>0 ? new JsonData(-1,"用户名已存在") : new JsonData(1,"用户名可用");
    }

    @PostMapping("/reg")
    public JsonData reg(@RequestBody User user){
        User saveUser = new User(user.getName(),user.getPassword());
        boolean regFlag = userDao.reg(saveUser);
        if(regFlag)
            return new JsonData(1,"注册成功");
        return new JsonData(-1,"注册失败");
    }

}
