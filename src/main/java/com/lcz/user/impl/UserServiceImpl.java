package com.lcz.user.impl;

import com.lcz.user.dao.UserDao;
import com.lcz.user.pojo.Constant;
import com.lcz.user.pojo.User;
import com.lcz.user.result.Result;
import com.lcz.user.service.UserService;
import com.lcz.user.utils.AESUtils;
import com.lcz.user.utils.IdWorker;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

/**
 * @author: lcz
 * @create: 2019-11-21 19:58
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    public void save(User user) {
        //使用aes加密手机号
        String phone = user.getPhone();
        String pwdPhone = AESUtils.AESEncode(phone, Constant.ErrorCode.KEY);
        //先判断手机号是否已经注册过
        User userByPhone = userDao.findUserByPhone(pwdPhone);
        if(userByPhone!=null){
            throw new RuntimeException("您已经注册过请登录");
        }

        long id = idWorker.nextId();
        user.setId(id + "");
        //密码加密
        String password = user.getPassword();
        String gensalt = BCrypt.gensalt();
        String hashpw = BCrypt.hashpw(password, gensalt);
        user.setPassword(hashpw);
        //使用aes加密身份证
        String card = user.getCard();
        String pwdCard = AESUtils.AESEncode(card, Constant.ErrorCode.KEY);
        user.setPhone(pwdPhone);
        user.setCard(pwdCard);
        userDao.save(user);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public Result login(User user) {
        //通过手机号查询用户
        String phone = user.getPhone();
        String pwdPhone = AESUtils.AESEncode(phone, Constant.ErrorCode.KEY);
        User userByPhone = userDao.findUserByPhone(pwdPhone);
        if (userByPhone==null){
            return new Result(Constant.ErrorCode.FAIL,null,"手机号不存在");
        }
        String password = userByPhone.getPassword();
        //检验密码是否正确
        boolean checkpw = BCrypt.checkpw(user.getPassword(), password);
       if(!checkpw){
           return new Result(Constant.ErrorCode.FAIL,null,"密码错误");
       }

        return new Result(Constant.ErrorCode.SUCCESS,null,"登录成功");
    }
}
