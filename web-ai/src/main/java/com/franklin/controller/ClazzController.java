package com.franklin.controller;

import com.franklin.dto.ClazzDTO;
import com.franklin.dto.ClazzQueryParamDTO;
import com.franklin.entity.PageResult;
import com.franklin.service.ClazzService;
import com.franklin.util.Result;
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
    public Result<PageResult<ClazzDTO>> getAll(ClazzQueryParamDTO clazzQueryParamDTO) {
        log.info("GET -- All users based on queryString");
        return Result.success(clazzService.getAll(clazzQueryParamDTO));
    }

    @PostMapping
    public Result create(@RequestBody ClazzDTO clazzDTO) {
        log.info("POST => create class with id {}", clazzDTO.getId());
        clazzService.create(clazzDTO);
        return Result.success();
    }

    /**
     * DELETE -- Delete class by id
     * @param id
     * @return result of delete
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("DELETE => /clazzs/{}", id);
        clazzService.delete(id);
        return Result.success();
    }

    /**
     * GET -- class data by Id
     * @param id
     * @return Result of Class data
     */
    @GetMapping("/{id}")
    public Result<ClazzDTO> get(@PathVariable Integer id) {
        log.info("GET => class data id {}", id);
        return Result.success(clazzService.get(id));
    }

    /**
     * PUT -- Update class data
     * @param clazzDTO
     * @return
     */
    @PutMapping
    public Result update(@RequestBody ClazzDTO clazzDTO) {
        log.info("PUT => update class data");
        clazzService.update(clazzDTO);
        return Result.success();
    }

}
