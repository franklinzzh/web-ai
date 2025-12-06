package com.franklin.dto.upload;

import lombok.Data;

/**
 * @Auther: franklin
 * @Date: 2025/11/29
 * @Description:
 */
@Data
public class PresignUrlDTO {
    private String path;
    // expire in minutes
    private Integer expire;
}


