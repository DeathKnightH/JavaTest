package cn.dk.base;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * list 数据结构测试
 */
@Service
public class ListTest {
    private StringRedisTemplate stringRedisTemplate;

    public ListTest(@NonNull StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public long lpush(String listName, List<String> value) {
        return stringRedisTemplate.opsForList().leftPushAll(listName, value);
    }

    /**
     * 右边出队列
     *
     * @param listName 队列名称
     * @return 值
     */
    public String rightPop(String listName) {
        return stringRedisTemplate.opsForList().rightPop(listName);
    }
}
