package com.jason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author jason
 * @date 2019-01-29 12:43
 * Description:
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value ="/say" , method = RequestMethod.GET)
    public String say(ModelMap modelMap){
        modelMap.addAttribute("msg", "hello!SpringBoot-thymeleaf。你好");
        return "hello";
    }

}
