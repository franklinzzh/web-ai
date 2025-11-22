package com.franklin.service;

import com.franklin.dto.StudentCreateDTO;
import com.franklin.dto.StudentQueryParamDTO;
import com.franklin.dto.StudentUpdateDTO;
import com.franklin.entity.PageResult;
import com.franklin.entity.Student;
import jakarta.validation.Valid;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/21
 * @Description:
 */
public interface StudentService {

    /**
     * Fetch paginated student list with filters
     * @param param
     * @return a list of students
     */
    PageResult<Student> getPage(StudentQueryParamDTO param);

    /**
     * create student
     * @param createDTO
     */
    void create(@Valid StudentCreateDTO createDTO);

    /**
     * Fetch student by ID
     * @param id
     * @return
     */
    Student get(Integer id);

    /**
     * Update student
     * @param updateDTO
     */
    void update(StudentUpdateDTO updateDTO);

    /**
     * Delete student by ID
     * @param id
     */
    void delete(Integer id);

    /**
     * Update student violation record
     * @param id
     * @param score
     */
    void updateViolation(Integer id, Integer score);

    /**
     * Check if class id has students
     * @param id
     * @return
     */
    boolean existsByClazzId(Integer id);

    /**
     * Check if name is unique in student
     * @param id
     * @return
     */
    boolean existsById(Integer id);

    /**
     * Check if name is unique in student
     * @param name
     * @return
     */
    boolean existsByName(String name);

    /**
     * Get student name
     * @param id
     * @return
     */
    String getName(Integer id);

}
