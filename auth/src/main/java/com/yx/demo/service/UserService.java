package com.yx.service;

import com.yx.dao.ShiroUserDao;
import com.yx.entity.user.Role;
import com.yx.entity.user.ShiroUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private ShiroUserDao shiroUserDao;

    public ShiroUser getShiroUserByUserName(String userName){
        Integer id = shiroUserDao.getIdByuserName(userName);
        List<Role> roleList = shiroUserDao.findRoleByUserId(id);
        ShiroUser user = shiroUserDao.getShiroUserByUserName(userName);
        user.setRoleList(roleList);
        return user;
    }

}
