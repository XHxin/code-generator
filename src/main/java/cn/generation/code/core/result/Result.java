package cn.generation.code.core.result;


import cn.generation.code.core.enums.ResultEnum;
import lombok.Data;

import java.util.HashMap;

/**
 * Http请求返回的最外层对象
 * @author leo
 * @date 2018/7/13 9:07
 */
@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
        this.data = data==null? (T)new HashMap<>() : data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = (T)new HashMap<>();
    }

    public Result(Integer code, String msg,T t) {
        this.code = code;
        this.msg = msg;
        this.data = t;
    }

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = (T)new HashMap<>();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
