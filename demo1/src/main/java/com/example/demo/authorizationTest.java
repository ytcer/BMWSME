package com.example.demo;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class authorizationTest extends AuthorizingRealm {
    HashSet<String> getPermissionsByUsers(String username){
        HashSet<String> permissions = new HashSet<>();
        permissions.add("user:add");
        return permissions;


    }
    HashSet<String> getRolesByUser(String username){
        HashSet<String> roles = new HashSet<>();
        roles.add("admin");
        return roles;
    }
    String getPasswordbyUsername(String Username){
        return objectObjectHashMap.get(Username);
    }

        HashMap<String, String> objectObjectHashMap = new HashMap<>();

    {
        objectObjectHashMap.put("admin", "123456");
        super.setName("myauthoriaztion");
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String )principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> admin = getPermissionsByUsers(username);
        HashSet<String> rolesByUser = getRolesByUser(username);
        simpleAuthorizationInfo.setRoles(rolesByUser);
        simpleAuthorizationInfo.setStringPermissions(admin);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String passwordbyUsername = getPasswordbyUsername(username);
        SimpleAuthenticationInfo simpleAuthorizationInfo = new SimpleAuthenticationInfo("admin", passwordbyUsername,"myauthentication");

        return simpleAuthorizationInfo;
    }

}
