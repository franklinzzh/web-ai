package com.franklin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
