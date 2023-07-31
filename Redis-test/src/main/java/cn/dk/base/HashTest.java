package cn.dk.base;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class HashTest {
    private RedisTemplate<String, String> redisTemplate;

    public HashTest(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setHash(String hash, String key, String value){
        redisTemplate.boundHashOps(hash).put(key, value);
    }

    public String getHashValue(String hash, String key){
        BoundHashOperations<String, Object, Object> hashOperations = redisTemplate.boundHashOps(hash);
        Object obj = hashOperations.get(key);
        return String.valueOf(obj);
    }
}
