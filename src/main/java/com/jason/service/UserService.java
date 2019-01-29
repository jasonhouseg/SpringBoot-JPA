package com.jason.service;

import com.jason.dao.UserDao;
import com.jason.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author jason
 * @date 2019-01-29 17:59
 * Description:
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void saveUser(User user) {
        userDao.save(user);
    }

    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    public List<User> findByUserNameContaining(String keyword) {
        return userDao.findByUserNameContaining(keyword);
    }

}
