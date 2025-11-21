package com.franklin.service;


import com.franklin.dto.GenderOptionDTO;
import com.franklin.dto.JobOptionDTO;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/19
 * @Description: Data Report Service
 */
public interface ReportService {

    /**
     * Emp job data
     * @return JobOptionDTO
     */
    JobOptionDTO getEmpJobData();

    /**
     * Emp Gender Data
     * @return List<GenderOptionDTO>
     */
    List<GenderOptionDTO> getEmpGenderData();
}
