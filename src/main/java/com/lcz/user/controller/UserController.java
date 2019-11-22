package com.lcz.user.controller;

import com.lcz.user.pojo.Constant;
import com.lcz.user.pojo.User;
import com.lcz.user.result.Result;
import com.lcz.user.service.UserService;
import com.lcz.user.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: lcz
 * @create: 2019-11-21 19:47
 **/
@RestController
@RequestMapping("/app/user")
public class UserController {
    @Autowired
    private UserService userService;


    //注册方法
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.save(user);
        return new Result(Constant.ErrorCode.SUCCESS, null, "保存成功");
    }

    //登录方法
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }
}
