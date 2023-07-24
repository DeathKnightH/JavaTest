package cn.dk.controller;

import cn.dk.base.StringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test/redis")
public class RedisController {
    @Autowired
    private StringTest stringTest;

    @PostMapping("/setstring")
    @ResponseBody
    public boolean setString(String key, String value){
        return stringTest.setString(key, value);
    }

    @GetMapping("/getstring")
    @ResponseBody
    public String getString(String key){
        return stringTest.getString(key);
    }
}
