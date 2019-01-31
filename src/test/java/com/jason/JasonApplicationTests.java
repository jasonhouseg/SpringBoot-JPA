package com.jason;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jason.dao.redis.BaseRedisDao;
import com.jason.dao.redis.RedisDao;
import com.jason.dao.redis.RedisListDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasonApplicationTests {

    @Autowired
    RedisListDao redisListDao;
    @Autowired
    RedisDao redisDao;

    @Test
    public void contextLoads() {
        System.out.println("begin======================");
        // 测试保存简单字符串
        redisDao.setKey("aa", "山东师范师范fadfas", 1L);// 1分钟过期
        System.out.println("redis里取出aa=============="+redisDao.getValue("aa"));

        // 测试保存 list 字符串(要通过 JSON.toJSONString(list) 才能保存到redis，否则类型会不匹配而保存不了)
        List list = new ArrayList();
        list.add("小米");
        list.add("华为");
        System.out.println(list);
        redisListDao.put("list", JSON.toJSONString(list), 30L);// 30秒过期。
        String strList = redisListDao.get("list");
        JSONArray jsonArray = JSONArray.parseArray(strList);// 把list格式的字符串转换为JSONArray
        List list2 = JSONArray.parseArray(strList);

        System.out.println("已保存于redis=========");
    }

}

