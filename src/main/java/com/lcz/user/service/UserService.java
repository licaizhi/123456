package com.lcz.user.service;

import com.lcz.user.pojo.User;
import com.lcz.user.result.Result;

/**
 * @author licz
 */
public interface UserService {
    void save(User user);

    Result login(User user);
}
