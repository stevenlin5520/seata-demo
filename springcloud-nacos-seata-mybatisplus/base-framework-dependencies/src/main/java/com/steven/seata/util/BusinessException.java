package com.steven.seata.util;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 16:27
 */
public class BusinessException extends RuntimeException {
    private String code;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(Result result) {
        super(result.getMsg());
        this.code = result.getCode();
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public String getCode() {
        return this.code;
    }
}
