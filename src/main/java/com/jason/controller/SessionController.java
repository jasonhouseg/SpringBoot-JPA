package com.jason.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Description: 测试session信息保存到redis类
 *
 * @author jason
 * @date 2019-02-01 14:46
 */
@Controller
@RequestMapping("/session")
public class SessionController {
    Logger logger = LoggerFactory.getLogger(SessionController.class);

    @RequestMapping("/putSession")
    @ResponseBody
    public String putSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        logger.info(session.getClass().getName());
        logger.info(session.getId());
        String name = "zhongJason";
        session.setAttribute("user", name);

        return "hello!"+name;
    }
}
