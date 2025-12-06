package com.franklin.mapper;

import com.franklin.dto.student.StudentCreateDTO;
import com.franklin.dto.student.StudentQueryParamDTO;
import com.franklin.dto.student.StudentUpdateDTO;
import com.franklin.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/21
 * @Description:
 */
@Mapper
public interface StudentMapper {

    /**
     * Fetch paginated student list with filters
     * @param param
     * @return
     */
    List<Student> getPage(StudentQueryParamDTO param);

    /**
     * create student
     * @param createDTO
     */
    void create(StudentCreateDTO createDTO);

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
     * Check if a class has students
     * @param clazzId
     * @return
     */
    boolean existsByClazzId(Integer clazzId);

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
