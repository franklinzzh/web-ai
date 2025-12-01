package com.franklin.service.impl;

import com.franklin.dto.report.GenderOptionDTO;
import com.franklin.dto.report.JobOptionDTO;
import com.franklin.dto.report.StudentCountDTO;
import com.franklin.dto.report.StudentDegreeDTO;
import com.franklin.mapper.ReportMapper;
import com.franklin.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: franklin
 * @Date: 2025/11/19
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;

    @Override
    public JobOptionDTO getEmpJobData() {
        List<Map<String, Object>> empJobData = reportMapper.getEmpJobData();
        List<String> jobList = empJobData.stream().map(row -> (String)row.get("pos")).toList();
        List<Long> dataList = empJobData.stream().map(row -> (Long)row.get("num")).toList();
        return new JobOptionDTO(jobList, dataList);
    }

    @Override
    public List<GenderOptionDTO> getEmpGenderData() {
        List<GenderOptionDTO> genderDataList = reportMapper.getEmpGenderData();
        return genderDataList;
    }

    @Override
    public StudentCountDTO fetchStudentCount() {
        List<Map<String, Object>> studentData = reportMapper.fetchStudentCount();
        List<String> clazzList = studentData.stream().map(row -> (String)row.get("name")).toList();
        List<Long> dataList = studentData.stream().map(row -> (Long)row.get("num")).toList();
        return new StudentCountDTO(clazzList, dataList);
    }

    @Override
    public List<StudentDegreeDTO> fetchStudentDegree() {
        return reportMapper.fetchStudentDegree();
    }

}
