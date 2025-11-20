package com.franklin.service;

import com.franklin.dto.ClazzDTO;
import com.franklin.dto.ClazzQueryParamDTO;
import com.franklin.entity.PageResult;

/**
 * @Auther: franklin
 * @Date: 2025/11/20
 * @Description: Class Service
 */
public interface ClazzService {

    /**
     * all class data in pages
     * @param clazzQueryParamDTO
     * @return
     */
    PageResult<ClazzDTO> getAll(ClazzQueryParamDTO clazzQueryParamDTO);

    /**
     * Create class
     * @param clazzDTO
     */
    void create(ClazzDTO clazzDTO);

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
     * @param clazzDTO
     */
    void update(ClazzDTO clazzDTO);
}
