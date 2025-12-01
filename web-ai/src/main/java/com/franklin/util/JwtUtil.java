package com.franklin.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: franklin
 * @Date: 2025/11/23
 * @Description: JwtToken Util
 */
public class JwtUtil {

    private static final String SECRET_KEY = "ysvp7R1QjhOlzWQjWpuAzd0QemR4ebW8yz1ghUzKE5M=";
    // expire in 12 hrs
    private static final long EXPIRATION_TIME = 12 * 3600_000;

    public static String generateToken(Integer userId) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .subject(userId.toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 12 * 3600_000))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .compact();
    }


    public static String extractSubject(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            // Parse and validate signature + expiration
            Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // Token invalid
            return false;
        }
    }

//    public static Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
}
