package com.franklin.controller;

import com.franklin.util.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: franklin
 * @Date: 2025/11/23
 * @Description:
 */
@Slf4j
@RestController
public class SessionController {
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {
        response.addCookie(new Cookie("login_username", "aaa"));
        return Result.success();
    }

    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login_username")) {
                System.out.println("login_username: " + cookie.getValue());
            }
        }
        return Result.success();
    }

    @GetMapping("s1")
    public Result session1(HttpSession session) {
        log.info("HttpSession /s1 -- Create Session: {}", session.hashCode());
        session.setAttribute("username", "Z..");
        return Result.success();
    }

    @GetMapping("s2")
    public Result session2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("HttpSession /s2 -- Get Session: {}", session.hashCode());
        Object username = session.getAttribute("username");
        log.info("Login user username: {}", username);
        return Result.success(username);
    }
}
