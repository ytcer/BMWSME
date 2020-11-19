package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class test{
    int i;
    String content;
    public test(int id, String content){
        this.i = id;
        this.content = content;
    }
    int return_content(){
        return this.i;
    }
    String return_id(){
        return this.content;
    }
}
@RestController
class testforapi{
    @RequestMapping("/test")
    public test api(@RequestParam(value = "id")int id,@RequestParam(value = "content")String content){
        return new test(id, content);


    }
}