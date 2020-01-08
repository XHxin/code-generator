package com.nelson.test.util;

import com.nelson.test.core.enums.ResultEnum;
import com.nelson.test.core.result.Result;

import java.util.HashMap;

/**
 * @author leo
 * @date 2018/7/13 9:14
 */
public class ResultUtil {

    public ResultUtil() {
    }

    /*
     * 请求成功
     */
    public static <T> Result success(T t) {
        return new Result(t);
    }

    /*
     * 请求成功
     */
    public static Result success() {
        return success(new HashMap<>());
    }

    /*
     * 请求成功
     */
    public static<T> Result success(Integer code, String msg, T t) {
        return new Result(code, msg,t);
    }

    /*
     * 请求失败
     */
    public static Result error(Integer code, String msg) {
        return new Result(code, msg);
    }

    /*
     * 请求失败
     */
    public static <T> Result error(Integer code, String msg, T t) {
        return new Result(code, msg, t);
    }

    /**
     * 请求失败
     * @param failure
     * @return
     */
    public static Result error(ResultEnum failure) {
        return new Result(failure.getCode(), failure.getMsg());
    }
}
