package com.jason.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jason.repository.UserRepository;
import com.jason.model.User;
import com.jason.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *  * Description:用户控制器
 *
 * @author jason
 * @date 2019-01-29 18:07
 */
@Api(value = "用户接口类", tags = "用户信息相关")
@Controller
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    /**
     * 添加用户
     */
    @ApiOperation(value = "添加用户", notes = "添加用户,入参:user")
    @RequestMapping("/save")
    public void saveUser () {
        User user = new User();
        user.setuserName("王五");
        user.setPassword("123123");
        userService.saveUser(user);
        logger.warn("添加用户成功======================");
    }

    /**
     * 查询用户
     * @return
     */
    @GetMapping(value = "/users")
    @ResponseBody
    public List<User> girlList() {
        // 查询所有用户
        List<User> users = userRepository.findAll();
        logger.info(users.toString());

        // 根据用户名精确查询用户
        User user = userService.findByUserName("李四");

        // 根据用户名模糊查询用户
        List<User> userList =  userRepository.findByUserNameContaining("四");

        // //SPEL表达式查询用户
        User user2 = userRepository.findByUserName("李四");

        // 占位符传值形式关联表查询用户及地址
        Map<String, Object> userAddr = userRepository.findUserAndAddressByUserName("李四");
        logger.warn(users.toString());
        return users;
    }

    /**
     * 根据id修改用户
     */
    @RequestMapping("/update/{id}")
    public void updateUser (@PathVariable("id") Long id) {
        User user = new User();
//        user.setId(id);
//        user.setuserName("李四-修改后");
//        user.setPassword("123123");
//        userService.saveUser(user);
        userRepository.updateById("888888", id);// 测试自定义repository
        logger.warn("修改用户信息成功======================");
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @RequestMapping(value = "/delete/{id}")
    public void girlDelete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        logger.info("删除成功=============================");
    }

}
