package com.franklin.controller;

import com.franklin.service.StudentService;
import com.franklin.util.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    private final StudentService studentService;

    @GetMapping
    public Result getAll() {
        return null;
    }
}
