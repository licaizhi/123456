package com.lcz.user.Exception;

import com.lcz.user.pojo.Constant;
import com.lcz.user.result.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: lcz
 * @create: 2019-11-22 20:05
 * 异常通知类
 **/
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result getException(Exception e) {
        return new Result(Constant.ErrorCode.EXCEPTION,null,e.getMessage());
    }

}
