package com.franklin.service;

import com.franklin.dto.ClazzCreateDTO;
import com.franklin.dto.ClazzDTO;
import com.franklin.dto.ClazzQueryParamDTO;
import com.franklin.dto.ClazzUpdateDTO;
import com.franklin.entity.PageResult;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/20
 * @Description: Class Service
 */
public interface ClazzService {

    /**
     * Get class data in pages
     * @param clazzQueryParamDTO
     * @return
     */
    PageResult<ClazzDTO> getPage(ClazzQueryParamDTO clazzQueryParamDTO);

    /**
     * Create new class
     * @param clazzCreateDTO
     */
    void create(ClazzCreateDTO clazzCreateDTO);

    /**
     * Delete class by id
     * @param id
     */
    void delete(Integer id);

    /**
     * Get class data by id
     * @param id
     * @return
     */
    ClazzDTO get(Integer id);

    /**
     * Update class data
     * @param dto
     */
    void update(ClazzUpdateDTO dto);

    /**
     * Get all class data
     */
    List<ClazzDTO> getAll();

    /**
     * Check existence of name
     * @param name
     * @return
     */
    boolean existsByName(String name);

    /**
     * Check existence of id
     * @param id
     * @return
     */
    boolean existsById(Integer id);
}
