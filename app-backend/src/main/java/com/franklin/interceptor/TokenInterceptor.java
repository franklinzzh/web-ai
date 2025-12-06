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
        CurrentHolder.setCurrentId(id);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion .... ");
        CurrentHolder.remove();
    }
}
