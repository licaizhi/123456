package com.lcz.user.result;

/**
 * @author: lcz
 * @create: 2019-11-21 19:27
 * 定义返回对象
 **/
public class Result {
    //状态码
    private String code;
    //返回数据
    private Object date;
    //返回的信息
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public Result(String code, Object date, String errorMsg) {
        this.code = code;
        this.date = date;
        this.errorMsg = errorMsg;
    }

    public Result() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
