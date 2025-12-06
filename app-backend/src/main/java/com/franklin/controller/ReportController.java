package com.franklin.controller;

import com.franklin.dto.report.GenderOptionDTO;
import com.franklin.dto.report.JobOptionDTO;
import com.franklin.dto.report.StudentCountDTO;
import com.franklin.dto.report.StudentDegreeDTO;
import com.franklin.service.ReportService;
import com.franklin.utils.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/19
 * @Description: Data Report Controller
 */
@Slf4j
@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    /**
     * GET -- Emp Job Data
     * @return Result
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("Get => --Emp Job Data");
        JobOptionDTO jobOptionDto = reportService.getEmpJobData();
        return Result.success(jobOptionDto);
    }

    /**
     * GET --Emp Gender Data
     * @return Result<List<GenderOptionDTO>>
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("GET => Emp Gender Data");
        List<GenderOptionDTO> genderDataList = reportService.getEmpGenderData();
        return Result.success(genderDataList);
    }

    /**
     * Fetch class name and student count
     * @return
     */
    @GetMapping("/studentCountData")
    public Result fetchStudentCount() {
        log.info("Get /report/studentCountData - Fetch each class student count");
        StudentCountDTO studentCountDTO = reportService.fetchStudentCount();
        return Result.success(studentCountDTO);
    }

    /**
     * Fetch student degree and count
     * @return
     */
    @GetMapping("/studentDegreeData")
    public Result fetchStudentDegree(){
        log.info("Get /report/studentDegreeData - Fetch student degree");
        List<StudentDegreeDTO> studentDegreeDTOs = reportService.fetchStudentDegree();
        return Result.success(studentDegreeDTOs);
    }

}
