package com.franklin.exception;

/**
 * @Auther: franklin
 * @Date: 2025/11/20
 * @Description:
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
