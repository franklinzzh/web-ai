package com.franklin.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Auther: franklin
 * @Date: 2025/11/17
 * @Description:
 */
@Data
public class EmpQueryParam {

    // Search name (optional)
    private String name;

    // Gender filter (optional)
    private Integer gender;

    // Start date (optional)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;

    // End date (optional)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

    // Pagination defaults
    private Integer page = 1;
    private Integer pageSize = 10;
}
