package com.franklin.util;


import lombok.Data;

/**
 * @Auther: franklin
 * @Date: 2025/11/15
 * @Description:
 */
@Data
public class Result<T> {
    private Integer code;   // 状态码，如 200, 400, 500
    private String message; // 提示信息
    private T data;         // 返回数据（泛型）

    // 成功（无数据）
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 200;
        result.message = "success";
        return result;
    }

    // 成功（带数据）
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = 200;
        result.message = "success";
        result.data = data;
        return result;
    }

    // 失败（自定义错误信息）
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.code = 500;
        result.message = message;
        return result;
    }

    // 失败（错误码 + 信息）
    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.code = code;
        result.message = message;
        return result;
    }
}

