package com.franklin.controller;

import com.franklin.annotation.LogOperation;
import com.franklin.dto.ClazzCreateDTO;
import com.franklin.dto.ClazzDTO;
import com.franklin.dto.ClazzQueryParamDTO;
import com.franklin.dto.ClazzUpdateDTO;
import com.franklin.entity.PageResult;
import com.franklin.service.ClazzService;
import com.franklin.util.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/20
 * @Description: Class Controller
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/clazzs")
public class ClazzController {

    private final ClazzService clazzService;

    /**
     * GET -- all class data in pages
     * @param clazzQueryParamDTO
     * @return
     */
    @GetMapping
    public Result<PageResult<ClazzDTO>> getPage(ClazzQueryParamDTO clazzQueryParamDTO) {
        log.info("GET /clazzs?page={}&pageSize={} - Fetch paginated class list",
                clazzQueryParamDTO.getPage(),
                clazzQueryParamDTO.getPageSize());
        return Result.success(clazzService.getPage(clazzQueryParamDTO));
    }

    @LogOperation
    @PostMapping
    public Result create(@Valid @RequestBody ClazzCreateDTO dto) {
        log.info("POST /clazzs - create new class with name: {}", dto.getName());
        clazzService.create(dto);
        return Result.success();
    }

    /**
     * DELETE -- Delete class by id
     * @param id
     * @return result of delete
     */
    @LogOperation
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("[DELETE] - request id={}", id);
        clazzService.delete(id);
        return Result.success();
    }

    /**
     * GET -- Fetch class data by Id
     * @param id
     * @return Result of Class data
     */
    @GetMapping("/{id}")
    public Result<ClazzDTO> get(@PathVariable Integer id) {
        log.info("[GET] - request id={}", id);
        return Result.success(clazzService.get(id));
    }

    /**
     * PUT -- Update class data
     * @param dto
     * @return
     */
    @LogOperation
    @PutMapping
    public Result update(@Valid @RequestBody ClazzUpdateDTO dto) {
        log.info("[PUT] - request body: {}", dto);
        clazzService.update(dto);
        return Result.success();
    }

    /**
     * GET -- Fetch all class name as a list
     * @return
     */
    @GetMapping("/list")
    public Result<List<String>> getList() {
        log.info("GET /clazzs - Fetch all class data");
        List<String> clazzList = clazzService.getList();
        return Result.success(clazzList);
    }

}
