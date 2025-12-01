package com.franklin.dto.emp;

import jakarta.validation.constraints.NotNull;
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

    // Job filter (optional)
    private Integer job;

    // Start date (optional)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;

    // End date (optional)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

    // Pagination defaults

    @NotNull
    private Integer page = 1;

    @NotNull
    private Integer pageSize = 10;
}
