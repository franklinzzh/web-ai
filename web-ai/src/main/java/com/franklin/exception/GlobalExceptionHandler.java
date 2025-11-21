package com.franklin.exception;

import com.franklin.util.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDate;

/**
 * @Auther: franklin
 * @Date: 2025/11/19
 * @Description: Global Exception Handler
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result ex(Exception e) {
        e.printStackTrace();//打印堆栈中的异常信息
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }

    // Handle runtime exceptions
    @ExceptionHandler(BusinessException.class)
    public Result handleBusiness(BusinessException e) {
        return Result.error(e.getMessage());
    }

    /** Handle @Valid DTO validation errors */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidation(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage(); // this is your @NotNull message

        return Result.error(errorMessage);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        if (e.getRequiredType() == LocalDate.class) {
            return Result.error("日期格式错误，正确格式为 yyyy-MM-dd");
        }
        return Result.error("请求参数类型错误");
    }
}
