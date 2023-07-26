package cn.dk.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 测试 Redis 基本数据类型
 * String
 *
 * @since 2023-7-21 21:01:12
 */
@Component
public class StringTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public boolean setString(String key, String testString) {
        redisTemplate.boundValueOps(key).set(testString);
        return true;
    }

    public boolean setString(String key, String testString, long timeout){
        redisTemplate.boundValueOps(key).set(testString, timeout, TimeUnit.SECONDS);
        return true;
    }

    public String getString(String key) {
        return redisTemplate.boundValueOps(key).get();
    }
}
