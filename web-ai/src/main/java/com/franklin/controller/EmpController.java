package com.franklin.controller;

import com.franklin.dto.EmpDto;
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
    public Result<PageResult<EmpDto>> getAll(EmpQueryParam empQueryParam) {
        log.info("GET => {}", empQueryParam);
        PageResult<EmpDto> pageResult = empService.getAll(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加员工
     * @return Result<PageResult<Emp>>
     */
    @PostMapping
    public Result<Emp> create(@RequestBody EmpDto empDto) {
        log.info("请求参数emp: {}", empDto);
        empService.create(empDto);
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

    /**
     * 根据Id查询员工
     * @param id
     * @return Result<Emp>
     */
    @GetMapping("/{id}")
    public Result<Emp> get(@PathVariable Integer id ) {
        log.info("GET /emps/{}", id);
        return empService.get(id);
    }

    /**
     * 更新员工信息
     * @param id
     * @param empDto
     * @return Result<Emp>
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody EmpDto empDto) {
        log.info("PUT /emps/{} => updating emp", id);
        return empService.update(id, empDto);
    }
}
