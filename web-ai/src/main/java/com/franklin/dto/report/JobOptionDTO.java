package com.franklin.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/19
 * @Description: Job Data DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOptionDTO {
    private List<String> jobList;
    private List<Long> dataList;
}

