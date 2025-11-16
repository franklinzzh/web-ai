package com.franklin.controller;

import com.franklin.common.Result;
import com.franklin.entity.PageResult;
import com.franklin.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Auther: franklin
 * @Date: 2025/11/16
 * @Description: 员工管理
 */
@Slf4j
@RequestMapping("/emps")
@RestController
@RequiredArgsConstructor
public class EmpController {

    private final EmpService empService;

    /**
     * 获取所有员工信息
     * @return
     */
    @GetMapping
    public Result getAll(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("查询员工信息, page={}, pageSize={}", page, pageSize);
        PageResult pageResult = empService.page(page, pageSize);
        return Result.success(pageResult);
    }

}
