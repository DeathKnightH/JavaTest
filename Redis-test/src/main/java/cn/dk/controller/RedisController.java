package cn.dk.controller;

import cn.dk.base.HashTest;
import cn.dk.base.ListTest;
import cn.dk.base.StringTest;
import cn.dk.base.bean.ListInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/test/redis")
public class RedisController {
    @Autowired
    private StringTest stringTest;

    @Autowired
    private HashTest hashTest;

    @Autowired
    private ListTest listTest;

    @PostMapping("/setstring")
    @ResponseBody
    public boolean setString(String key, String value, @RequestParam(required = false, defaultValue = "0") long timeout){
        if(timeout == 0){
            return stringTest.setString(key, value);
        }
        return stringTest.setString(key, value, timeout);
    }

    @PostMapping("/setStringBatch")
    @ResponseBody
    public boolean setString(@RequestBody Map<String, String> keyValues){
        return stringTest.setStringBatch(keyValues);
    }

    @GetMapping("/getstring")
    @ResponseBody
    public String getString(String key){
        return stringTest.getString(key);
    }

    @PostMapping("/setHashString")
    @ResponseBody
    public boolean setHashString(String hashName, String key, String value){
        hashTest.setHash(hashName, key, value);
        return true;
    }

    @GetMapping("/getHashString")
    @ResponseBody
    public String getHashString(String hashName, String key){
        return hashTest.getHashValue(hashName, key);
    }

    @PostMapping("leftPush")
    @ResponseBody
    public long addValueToList(@RequestBody ListInput listInput){
        return listTest.lpush(listInput.getKey(), listInput.getValues());
    }

    @PostMapping("rightPop")
    @ResponseBody
    public String rightPop(String key){
        return listTest.rightPop(key);
    }
}
