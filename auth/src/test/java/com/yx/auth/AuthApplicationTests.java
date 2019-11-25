package com.yx.auth;

import com.yx.auth.dao.ShiroUserDao;
import com.yx.auth.entity.user.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthApplicationTests {

    @Autowired
    private ShiroUserDao shiroUserDao;

    @Test
    public void contextLoads() {
        List<Role> roleByUserId = shiroUserDao.findRoleByUserId(1);
//        List<Permission> permissionByRoleId = shiroUserDao.findPermissionByRoleId(1);
        System.out.println();

    }

}
