package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import static java.lang.System.out;

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
@Controller
class testforapi{
    @RequestMapping("/test")
    public String api(@RequestParam(value = "id", defaultValue = "123")int id,@RequestParam(value = "content", defaultValue = "string")String content){
        String safe = HtmlUtils.htmlEscape(content);

        out.println("<html>");
        String s = "<html>"+"<h>" + safe + "</h>"+"</html>";
        out.println(safe);
        return s;


    }
}