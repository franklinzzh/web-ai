package com.franklin.aspect;

import com.franklin.annotation.LogOperation;
import com.franklin.entity.OperateLog;
import com.franklin.service.LogService;
import com.franklin.utils.CurrentHolder;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.constant.Constable;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Auther: franklin
 * @Date: 2025/11/23
 * @Description:
 */
@Aspect
@Component
@RequiredArgsConstructor
public class OperationLogAspect {

    private final LogService logService;

    @Around("@annotation(log)")
    public Object around(ProceedingJoinPoint joinPoint, LogOperation log) throws Throwable {
        // 记录开始时间
        long startTime = System.currentTimeMillis();

        Object result = null;
        Exception exception = null;

        try {
            result = joinPoint.proceed();    // If throws, jumps to catch
            return result;
        } catch (Exception ex) {
            exception = ex;                  // Record exception
            throw ex;                        // Re-throw so controller handles it
        } finally {
            // 当前时间
            long endTime = System.currentTimeMillis();
            // 耗时
            long costTime = endTime - startTime;

            // 构建日志对象
            OperateLog operateLog = new OperateLog();
            operateLog.setOperateEmpId(getCurrentUserId()); // 需要实现 getCurrentUserId 方法
            operateLog.setOperateTime(LocalDateTime.now());
            operateLog.setClassName(joinPoint.getTarget().getClass().getName());
            operateLog.setMethodName(joinPoint.getSignature().getName());
            operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
            operateLog.setReturnValue(result == null ? null : result.toString());

            if (exception != null) {
                operateLog.setException(
                    exception.getClass().getSimpleName() + ": " + exception.getMessage()
                );
            }
            operateLog.setCostTime(costTime);

            // 插入日志
            logService.writeLogAsync(operateLog);
        }
    }

    // 示例方法，获取当前用户ID
    private int getCurrentUserId() {
        // 这里应该根据实际情况从认证信息中获取当前登录用户的ID
        return CurrentHolder.getCurrentId();
    }
}
