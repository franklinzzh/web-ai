package com.franklin.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Auther: franklin
 * @Date: 2025/11/25
 * @Description:
 */
@Data
public class EmpExprCreateDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //结束时间

    private String company; //公司名称
    private String job; //职位
}
