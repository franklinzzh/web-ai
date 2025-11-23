package com.franklin;

import com.franklin.util.JwtUtil;
import io.jsonwebtoken.Claims;
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
        int id = 61;
        String username = "test01";
        String token = JwtUtil.generateToken(id, username);
        System.out.println(token);
    }

    @Test
    void testParseToken() {
        int id = 61;
        String username = "test01";
        String token = "adfasfsd";
        Claims claims = JwtUtil.parseToken(token);
        Integer parseId = (Integer) claims.get("id");
        String parseUsername = (String) claims.get("username");
        System.out.println(claims);
        Assertions.assertAll(
                () -> Assertions.assertEquals(id, parseId),
                () -> Assertions.assertEquals(username, parseUsername)
        );
    }

    @Test
    void testGenerateAndParseToken() {
        int id = 61;
        String username = "test01";
        String token = JwtUtil.generateToken(id, username);
        System.out.println(token);
        Claims claims = JwtUtil.parseToken(token);
        Integer parseId = (Integer) claims.get("id");
        String parseUsername = (String) claims.get("username");
        System.out.println(claims);
        Assertions.assertAll(
                () -> Assertions.assertEquals(id, parseId),
                () -> Assertions.assertEquals(username, parseUsername)
        );
    }

}
