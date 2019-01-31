package com.jason;

import com.jason.dao.redis.BaseRedisDao;
import com.jason.dao.redis.RedisDao;
import com.jason.dao.redis.RedisListDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasonApplicationTests {

    @Autowired
    RedisListDao redisListDao;
    @Autowired
    RedisDao redisDao;

    @Test
    public void contextLoads() {
        System.out.println("开始==========");
        redisDao.setKey("aa", "山东师范师范fadfas");
        System.out.println("redis里取出aa=============="+redisDao.getValue("aa"));
        System.out.println("已保存于redis=========");
    }

}

