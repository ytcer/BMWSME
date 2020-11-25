package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InputValidation {
   /* @GetMapping("/InputValidation")
    String Validation(){
        return "form";
    }*/
    @GetMapping("/InputValidation")
    String Validation(@RequestParam(value = "age")int age, @RequestParam(value = "name")String name){
        String s = HtmlUtils.htmlEscape(name);
        String clean = Jsoup.clean(s, Whitelist.basic());
        student student = new student(age, clean);
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(student.get_age(),student.get_name());
        return  clean;



    }
}
class student{
    student(int age, String name) {
    this.name=name;
    this.age=age;
    }
    int age;
    String name;
    void set_age(int age){
        this.age = age;
    }
    void set_name(String name){
        this.name = name;
    }

    int get_age(){
        return this.age;

    }
    String get_name(){
        return this.name;
    }
}