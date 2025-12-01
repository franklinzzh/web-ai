package com.franklin.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Auther: franklin
 * @Date: 2025/11/30
 * @Description:
 */
@Data
@NoArgsConstructor
public class File {
    private Integer id;
    private String name;
    private String path;
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
