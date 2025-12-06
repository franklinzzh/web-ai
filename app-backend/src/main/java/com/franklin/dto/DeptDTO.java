package com.franklin.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Auther: franklin
 * @Date: 2025/11/22
 * @Description:
 */
@Data
@NoArgsConstructor
public class DeptDTO {
    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
