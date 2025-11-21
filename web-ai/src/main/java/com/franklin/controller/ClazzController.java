package com.franklin.controller;

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
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("[DELETE] - request id={}", id);
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
        log.info("[GET] - request id={}", id);
        return Result.success(clazzService.get(id));
    }

    /**
     * PUT -- Update class data
     * @param dto
     * @return
     */
    @PutMapping
    public Result update(@RequestBody ClazzUpdateDTO dto) {
        log.info("[PUT] - request body: {}", dto);
        clazzService.update(dto);
        return Result.success();
    }

    @GetMapping("/all")
    public Result getAll() {
        log.info("GET /clazzs - Fetch all class data");
        List<ClazzDTO> clazzDTOList = clazzService.getAll();
        return Result.success(clazzDTOList);
    }

}
