package com.franklin.aspect;

import com.franklin.service.impl.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Auther: franklin
 * @Date: 2025/11/23
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class RecordTimeAspect {

    @Around("execution(* com.franklin.service.impl.DeptServiceImpl.*(..))")
    public Object recordTime(ProceedingJoinPoint pjd) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = pjd.proceed();
        long end = System.currentTimeMillis();
        log.info("Dept Service Methods take times: {}ms", end - begin);
        return result;
    }

}
