package com.franklin.controller;

import com.franklin.dto.JobOptionDTO;
import com.franklin.service.ReportService;
import com.franklin.util.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * GET -- Emp job data count
     * @return Result
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("Get => --empJobData");
        JobOptionDTO jobOptionDto = reportService.getEmpJobData();
        return Result.success(jobOptionDto);
    }
}
