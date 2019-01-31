package com.jason.service;

import com.jason.repository.UserRepository;
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
    private UserRepository UserRepository;

    public void saveUser(User user) {
        UserRepository.save(user);
    }

    public User findByUserName(String userName) {
        return UserRepository.findByUserName(userName);
    }

    @Transactional
    public void deleteById(Long id) {
        UserRepository.deleteById(id);
    }

    public List<User> findByUserNameContaining(String keyword) {
        return UserRepository.findByUserNameContaining(keyword);
    }

}
