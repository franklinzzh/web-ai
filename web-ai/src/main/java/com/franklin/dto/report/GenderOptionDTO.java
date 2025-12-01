package com.franklin.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: franklin
 * @Date: 2025/11/20
 * @Description: Gender Data DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenderOptionDTO {
    private String name;
    private Long value;
}
