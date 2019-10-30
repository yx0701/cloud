package com.yx.demo.controller;

import com.yx.demo.dao.ShiroUserDao;
import com.yx.demo.entity.user.Permission;
import com.yx.demo.entity.user.Role;
import com.yx.demo.entity.user.ShiroUser;
import com.yx.demo.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HtmlController {


    @Autowired
    private UserService userService;

    @Autowired
    private ShiroUserDao shiroUserDao;

    @GetMapping("/root")
    @RequiresRoles("root")
    public String root(){
        return "root";
    }

    @GetMapping("/common")
    @RequiresPermissions("root_perm")
    public String common(){
        return "common";
    }

    @GetMapping("/findPermissionByRoleId")
    public List<Permission> findPermissionByRoleId(String id){
        return shiroUserDao.findPermissionByRoleId(1);
    }

    @GetMapping("/findRoleByUserId")
    public List<Role> findRoleByUserId(String id){
        return shiroUserDao.findRoleByUserId(1);
    }

    @GetMapping("/findAllInfoByUserId")
    public ShiroUser findAllInfoByUserId(String userName){
        return userService.getShiroUserByUserName(userName);
    }


}
