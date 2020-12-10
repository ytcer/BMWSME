package com.example.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
@RestController
public class authenticationTest{
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();


    @GetMapping("/register")
    public void setUserAccount(@RequestParam(value = "username")String user_name, @RequestParam(value="password")String user_password){
        simpleAccountRealm.addAccount(user_name,user_password);




    }
    @GetMapping("/login")
    public void setUserAuthentication(@RequestParam(value = "username") String user_name, @RequestParam(value="password") String password){
        DefaultSecurityManager DefaultsecurityManager = new DefaultSecurityManager();
        DefaultsecurityManager.setRealm(simpleAccountRealm);
        SecurityUtils.setSecurityManager(DefaultsecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user_name,password);
        subject.login(token);
            //subject.checkRole("admin");
            if (subject.isAuthenticated()) {
                System.out.println("success");
            } else {
                System.out.println("failed");
            }

    }
    @GetMapping("/logout")
    public void logout(){


    }
}