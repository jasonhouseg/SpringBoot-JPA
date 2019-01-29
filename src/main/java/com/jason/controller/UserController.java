package com.jason.controller;

import com.jason.dao.UserDao;
import com.jason.model.User;
import com.jason.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  * Description:用户控制器
 *
 * @author jason
 * @date 2019-01-29 18:07
 */
@Controller
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    /**
     * 添加用户
     */
    @RequestMapping("/save")
    public void saveUser () {
        User user = new User();
        user.setuserName("李四");
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
        List<User> users = userDao.findAll();
        logger.info(users.toString());

        // 根据用户名精确查询用户
        User user = userService.findByUserName("李四");

        // 根据用户名模糊查询用户
        List<User> userList =  userDao.findByUserNameContaining("四");
        return users;
    }

    /**
     * 根据id修改用户
     */
    @RequestMapping("/update/{id}")
    public void updateUser (@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setuserName("李四-修改后");
        user.setPassword("123123");
        userService.saveUser(user);
        logger.warn("修改用户成功======================");
    }

    /**
     * 删除一个女生
     *
     * @param id
     */
    @RequestMapping(value = "/delete/{id}")
    public void girlDelete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        logger.info("删除成功=============================");
    }

}
