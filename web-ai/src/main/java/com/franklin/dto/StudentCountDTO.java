package com.franklin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/22
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCountDTO {
    List<String> clazzList;
    List<Long> dataList;
}
