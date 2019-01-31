package com.jason.repository;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jason.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**`
 * @author jason
 * @date 2019-01-29 17:57
 * Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUserName(String userName);

    void deleteById(Long id);

    List<User> findByUserNameContaining(String keyword);

    // 自定义repository。手写sql
    // 修改用户信息
    @Transactional// 删改需要加事物
    @Query(value = "update User set password=?1 where id=?2",nativeQuery = true)   //占位符传值形式
    @Modifying
    int updateById(String password, Long id);

    // 单表查询
    @Query("from User u where u.userName = : userName")   // SPEL表达式，注意要通过模型如 User 及其属性如 userName 查询
    User findUserByUserName(@Param("userName") String userName);// 参数userName 映射到数据库字段userName

    // 2个表关联查询
    @Query("select u.id, u.userName, a.address from User u, Address a where u.id = a.userId and u.userName = ?1")   // 占位符传值形式
    Map<String, Object> findUserAndAddressByUserName(@Param("userName") String userName);

}
