package com.jason.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jason
 * @date 2019-01-29 12:43
 * Description:
 */
@Api(value = "hello接口类", tags = "hello接口类")
@Controller
@RequestMapping("/hello")
public class HelloController {

    @ApiOperation(value = "打招呼", notes = "打招呼")
    @RequestMapping(value ="/say" , method = RequestMethod.GET)
    public String say(ModelMap modelMap){
        modelMap.addAttribute("msg", "hello!SpringBoot-thymeleaf。你好");
        return "hello";
    }

    @ApiOperation(value = "获取map信息", notes = "获取map信息")
    @RequestMapping(value ="/mapInfo" , method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> mapInfo(){
        Map<String, Object> map = new HashMap<>();
        map.put("a", "dfadf");
        map.put("b", "發士大夫");
        map.put("c", "reha是否是");
        return map;
    }

    @ApiIgnore// 使用该注解，表示Swagger2忽略这个API（不会在swagger在线文档中显示此接口）,但在浏览器中可以直接请求url。
    @RequestMapping(value ="/ignore" , method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> ignore(){
        Map<String, Object> map = new HashMap<>();
        map.put("aa", "隐藏xxx");
        map.put("b", "發士大夫");
        map.put("c", "reha是否是");
        return map;
    }

}
