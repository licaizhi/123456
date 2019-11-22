package com.lcz;

import com.lcz.user.pojo.User;
import com.lcz.user.result.Result;
import com.lcz.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

    @Autowired
    private UserService userService;

    /**
     * 注册测试
     */
    @Test
    public void testRegister() {
        User user = new User();
        user.setUsername("张三");
        user.setPhone("13888889999");
        user.setPassword("123456");
        user.setCard("22222222222222222");
        userService.save(user);
    }

    /**
     * 登录测试
     */
    @Test
    public void testLogin() {
        User user = new User();
        user.setPhone("13888889999");
        user.setPassword("123456");
        Result login = userService.login(user);
        System.out.println(login);
    }
}
