package com.jason.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Description: Redis存取简单字符串类
 *
 * @author jason
 * @date 2019-01-31 13:17
 */
@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    public void setKey(String key, String value, long expire) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key, value, expire, TimeUnit.MINUTES);
    }

    public String getValue(String key) {
        ValueOperations<String ,String> ops = this.stringRedisTemplate.opsForValue();
        return ops.get(key);
    }

}
