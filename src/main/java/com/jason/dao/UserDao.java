package com.jason.dao;

import com.jason.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jason
 * @date 2019-01-29 17:57
 * Description:
 */
public interface UserDao extends JpaRepository<User, String> {

    User findByUserName(String userName);

    void deleteById(Long id);

    List<User> findByUserNameContaining(String keyword);

}
