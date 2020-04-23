package cn.org.cvc.core.exception;

import cn.org.cvc.core.enums.ResultEnum;


/**
* 自定义异常类
* Created by Nelson on 2020/4/7.
*/
public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public CustomException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
