package com.steven.seata.util;

import lombok.Data;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 13:07
 */
@Data
public class Result {

    final public static String RESULT_OK = "200";
    final public static String RESULT_FAIL = "500";

    private String code;

    private String msg;

    private Object data;

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(String msg, Object data) {
        return new Result(RESULT_OK,msg,data);
    }

    public static Result success(Object data) {
        return new Result(RESULT_OK,"成功",data);
    }

    public static Result success() {
        return new Result(RESULT_OK,"成功",null);
    }

    public static Result failed(String msg, Object data) {
        return new Result(RESULT_FAIL,msg,data);
    }

    public static Result failed(Object data) {
        return new Result(RESULT_FAIL,"失败",data);
    }

    public static Result failed() {
        return new Result(RESULT_FAIL,"失败",null);
    }
}
