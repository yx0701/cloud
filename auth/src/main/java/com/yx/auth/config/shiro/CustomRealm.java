package com.yx.auth.config.shiro;

import com.yx.auth.entity.user.Permission;
import com.yx.auth.entity.user.Role;
import com.yx.auth.entity.user.ShiroUser;
import com.yx.auth.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权 doGetAuthorizationInfo");
        ShiroUser newShiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
        ShiroUser user = userService.getShiroUserByUserId(newShiroUser.getId());

        List<String> stringRoleList = new ArrayList<>();
        List<String> stringPermissionList = new ArrayList<>();

        List<Role> roleList = user.getRoleList();
        for(Role role : roleList){
            stringRoleList.add(role.getName());
            for(Permission permission : role.getPermissionList()){
                if(permission != null)
                stringPermissionList.add(permission.getName());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(stringRoleList);
        simpleAuthorizationInfo.addStringPermissions(stringPermissionList);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证 doGetAuthenticationInfo");
        String id = (String)token.getPrincipal();
        ShiroUser shiroUser = userService.getShiroUserByUserId(id);
        String pwd = shiroUser.getPassword();
        if(null == pwd || "".equals(pwd.trim())) {
            return null;
        }
        return new SimpleAuthenticationInfo(shiroUser,pwd,this.getClass().getName());
    }
}
