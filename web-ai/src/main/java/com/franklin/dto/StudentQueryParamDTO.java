package com.franklin.dto;

import lombok.Data;

/**
 * @Auther: franklin
 * @Date: 2025/11/21
 * @Description:
 */
@Data
public class StudentQueryParamDTO {

    // optional
    private String name;
    private Integer degree;
    private Integer clazzId;

    // Pagination Default
    private Integer page = 1;
    private Integer pageSize = 10;
}
