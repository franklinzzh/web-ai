package com.franklin.service.impl;

import com.franklin.dto.JobOptionDTO;
import com.franklin.mapper.ReportMapper;
import com.franklin.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

/**
 * @Auther: franklin
 * @Date: 2025/11/19
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;

    /**
     * Emp job data count
     */
    public JobOptionDTO getEmpJobData() {
        List<Map<String, Object>> empJobData = reportMapper.getEmpJobData();
        List<String> jobList = empJobData.stream().map(row -> (String)row.get("pos")).toList();
        List<Long> dataList = empJobData.stream().map(row -> (Long)row.get("num")).toList();
        return new JobOptionDTO(jobList, dataList);
    }

}
