package com.lcz.user.dao;

import com.lcz.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author licz
 */
public interface UserDao extends JpaRepository<User,String> {

    public User findUserByPhone(String phone);

}
