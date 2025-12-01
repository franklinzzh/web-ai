package com.franklin.dto.clazz;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Auther: franklin
 * @Date: 2025/11/21
 * @Description: Clazz DTO for Create
 */
@Data
@NoArgsConstructor
public class ClazzCreateDTO {

    @NotEmpty(message = "name is required")
    private String name; //班级名称

    @NotEmpty(message = "room is required")
    private String room; //班级教室

    @NotNull(message = "beginDate is required")
    @DateTimeFormat(pattern = ("yyyy-MM-dd"))
    private LocalDate beginDate; //开课时间

    @NotNull(message = "endDate is required")
    @DateTimeFormat(pattern = ("yyyy-MM-dd"))
    private LocalDate endDate; //结课时间

    @NotNull(message = "subject is required")
    private Integer subject; //学科

    // Optional
    private Integer masterId; //班主任
}
