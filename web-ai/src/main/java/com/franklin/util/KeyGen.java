package com.franklin.util;

/**
 * @Auther: franklin
 * @Date: 2025/11/23
 * @Description: Generate SecretKey with 256 bits
 */
import java.security.SecureRandom;
import java.util.Base64;

public class KeyGen {
    public static void main(String[] args) {
        byte[] key = new byte[32];  // 32 bytes = 256 bits
        new SecureRandom().nextBytes(key);
        System.out.println(Base64.getEncoder().encodeToString(key));
    }
}

