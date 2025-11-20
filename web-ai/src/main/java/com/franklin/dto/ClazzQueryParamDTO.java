package com.franklin.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Auther: franklin
 * @Date: 2025/11/20
 * @Description: Params needed for Query on Clazz table
 */
@Data
public class ClazzQueryParamDTO {
    // Search name (optional)
    private String name;
    // Begin Date (optional)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    // End Date (optional)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
    // Pagination Default
    private Integer page = 1;
    private Integer pageSize = 10;
}
