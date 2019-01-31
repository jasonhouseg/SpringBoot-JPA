package com.jason.controller;

import com.jason.dao.redis.RedisSessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Description: 测试保存sessionId到redis类(可以用 sessionId 或设备id作为key)
 *
 * @author jason
 * @date 2019-01-31 15:05
 */
@Controller
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    RedisSessionDao redisSessionDao;

    @RequestMapping("sess")
    public String sessionTest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        redisSessionDao.put("sessionId-"+sessionId, "需要保存的信息XXX"+System.currentTimeMillis(), 180);// 保存xxx秒
        List<String> list = redisSessionDao.getAll();
        Map<String, String> map = redisSessionDao.getAllEntries();
        request.setAttribute("sessionId", list.toString());

        return "sessionFromRedis";
    }
}


