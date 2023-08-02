package cn.dk.base;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * hash 数据结构 test
 */
@Component
public class HashTest {
    private RedisTemplate<String, String> redisTemplate;

    public HashTest(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    /**
     * 设置一个 hash 内的 key-value 对
     *
     * @param hash hash 对象的 key 值
     * @param key   hash 内的 key
     * @param value hash 内 key 对应的 value
     */
    public void setHash(String hash, String key, String value){
        redisTemplate.boundHashOps(hash).put(key, value);
    }

    /**
     * @param hash hash 对象的 key
     * @param key   hash 内值的key
     * @return
     */
    public String getHashValue(String hash, String key){
        BoundHashOperations<String, Object, Object> hashOperations = redisTemplate.boundHashOps(hash);
        Object obj = hashOperations.get(key);
        return String.valueOf(obj);
    }
}
