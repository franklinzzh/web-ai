package com.franklin.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Auther: franklin
 * @Date: 2025/11/21
 * @Description: Clazz DTO fro Update
 */
@Data
@NoArgsConstructor
public class ClazzUpdateDTO {

    @NotNull(message = "ID is required")
    private Integer id; //ID

    @NotEmpty(message = "name is required")
    private String name; //班级名称

    @NotEmpty(message = "room is required")
    private String room; //班级教室

    @NotNull(message = "beginDate is required")
    private LocalDate beginDate; //开课时间

    @NotNull(message = "endDate is required")
    private LocalDate endDate; //结课时间

    @NotNull(message = "masterId is required")
    private Integer masterId; //班主任

    // Optional
    private Integer subject; //学科

}
