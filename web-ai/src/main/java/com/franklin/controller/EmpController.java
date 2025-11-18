package com.franklin.controller;

import com.franklin.util.Result;
import com.franklin.dto.EmpQueryParam;
import com.franklin.entity.Emp;
import com.franklin.entity.PageResult;
import com.franklin.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Auther: franklin
 * @Date: 2025/11/16
 * @Description: Employee controller
 */
@Slf4j
@RequestMapping("/emps")
@RestController
@RequiredArgsConstructor
public class EmpController {

    private final EmpService empService;

    /**
     * 员工列表查询
     * @return Result<PageResult<Emp>>
     */
    @GetMapping
    public Result<PageResult<Emp>> getAll(EmpQueryParam empQueryParam) {
        log.info("GET => {}", empQueryParam);
        PageResult<Emp> pageResult = empService.getAll(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加员工
     * @return Result<PageResult<Emp>>
     */
    @PostMapping
    public Result<Emp> create(@RequestBody Emp emp) {
        log.info("请求参数emp: {}", emp);
        empService.create(emp);
        return Result.success();
    }

    /**
     * 删除员工
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("DELETE => {}", ids);
        empService.delete(ids);
        return Result.success();
    }
}
