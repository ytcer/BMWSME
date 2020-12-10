package com.example.demo;

import com.example.demo.DAO.User;
import com.example.demo.UserMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserMyBatis {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/show")
    public int showuser(@RequestParam("id")int id){
        return userMapper.DeleteById(id);
    }

}
