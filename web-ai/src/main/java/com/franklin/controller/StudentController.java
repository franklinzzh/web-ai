package com.franklin.controller;

import com.franklin.dto.StudentCreateDTO;
import com.franklin.dto.StudentQueryParamDTO;
import com.franklin.dto.StudentUpdateDTO;
import com.franklin.entity.PageResult;
import com.franklin.entity.Student;
import com.franklin.service.StudentService;
import com.franklin.util.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/21
 * @Description: Student controller
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    /**
     * GET -- Fetch paginated student list with filters
     * @param param
     * @return
     */
    @GetMapping
    public Result<PageResult<Student>> getPage(StudentQueryParamDTO param) {
        log.info("GET /students - Fetch paginated student list with filters: {}", param);
        PageResult<Student> studentList = studentService.getPage(param);
        return Result.success(studentList);
    }

    /**
     * Create student
     * @param createDTO
     * @return
     */
    @PostMapping
    public Result create(@Valid @RequestBody StudentCreateDTO createDTO) {
        log.info("Post /students - Create student: {}", createDTO);
        studentService.create(createDTO);
        return Result.success();
    }

    /**
     * Fetch student by ID
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("Get /students/{} - Fetch student by ID", id);
        Student student = studentService.get(id);
        return Result.success(student);
    }

    /**
     * Update student
     * @param updateDTO
     * @return
     */
    @PutMapping
    public Result update(@Valid @RequestBody StudentUpdateDTO updateDTO) {
        log.info("Put /students - Update student: {}", updateDTO);
        studentService.update(updateDTO);
        return Result.success();
    }
}
