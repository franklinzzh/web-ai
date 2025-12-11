package com.franklin.interceptor;

import com.franklin.utils.CurrentHolder;
import com.franklin.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Auther: franklin
 * @Date: 2025/12/02
 * @Description:
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 获取请求url。
        String url = request.getRequestURL().toString();

        /**
         * Question: why comment this?
         * Reason: In WebConfig.java, it already sets up excludePath
         */
//        //2. allow login url
//        if (url.contains("login")) {
//            log.info("Login request, allowed");
//            return true;
//        }

        //3. get token
        String token = request.getHeader("token");

        //4. check token is not empty
        if (!StringUtils.hasLength(token)) {
            log.info("token cannot be empty");
            response.setStatus(401);//unauthorized
            return false;
        }

        //5. check token validation
        if(!JwtUtil.validateToken(token)) {
            log.info("invalid token");
            response.setStatus(401);
            return false;
        }

        log.info("verified token, allowed");
        Integer id = Integer.valueOf(JwtUtil.extractSubject(token));

        //6. set up current user id in threadlocal
        CurrentHolder.setCurrentId(id);
        System.out.println("Interceptor CH: "+ CurrentHolder.getCurrentId());
        return true;
    }

    /**
     * Removing data store in ThreadLocal, Filter is a better choice
     * In Interceptor, afterCompletion does not mean the end of current thread,
     *                 like throwing an error may not finish yet.
     * While in Filter, it is the last step to finish it in backend.
     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion .... ");
//        CurrentHolder.remove();
//    }
}
