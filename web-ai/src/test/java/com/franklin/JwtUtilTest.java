package com.franklin;

import com.franklin.utils.JwtUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Auther: franklin
 * @Date: 2025/11/23
 * @Description:
 */
public class JwtUtilTest {

    @Test
    void testGenerateToken() {
        Integer id = 61;
//        String username = "test01";
        String token = JwtUtil.generateToken(id);
        System.out.println(token);
    }

    @Test
    void testParseToken() {
        Integer id = 61;
        String username = "test01";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2MSIsImlhdCI6MTc2NDU3ODkyMiwiZXhwIjoxNzY0NjIyMTIyfQ.sXl5f6qqsafgQ2U3oBEGbMJi2lPlQx6F5jXAZ855dE8";
        Integer parseId = Integer.valueOf(JwtUtil.extractSubject(token));
        System.out.println(parseId);
        Assertions.assertAll(
                () -> Assertions.assertEquals(id, parseId)
//                () -> Assertions.assertEquals(username, parseUsername)
        );
    }

//    @Test
//    void testGenerateAndParseToken() {
//        int id = 61;
//        String username = "test01";
//        String token = JwtUtil.generateToken(id);
//        System.out.println(token);
//        Claims claims = JwtUtil.extractAllClaims(token);
//        Integer parseId = (Integer) claims.get("id");
//        String parseUsername = (String) claims.get("username");
//        System.out.println(claims);
//        Assertions.assertAll(
//                () -> Assertions.assertEquals(id, parseId),
//                () -> Assertions.assertEquals(username, parseUsername)
//        );
//    }

}
