package com.example.demo.result;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_Fail_MESSAGE = "Fail";


    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }


    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    public static Result genFailResult(ResultCode resultCode) {
        return new Result()
                .setCode(resultCode.getCode())
                .setMessage(resultCode.getMsg());
    }

    public static Result genFailResult(Object data) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(DEFAULT_Fail_MESSAGE)
                .setData(data);
    }
}