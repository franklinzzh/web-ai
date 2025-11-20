package com.franklin.mapper;

import com.franklin.dto.ClazzDTO;
import com.franklin.dto.ClazzQueryParamDTO;
import com.franklin.entity.PageResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/20
 * @Description: Class Mapper
 */
@Mapper
public interface ClazzMapper {

    /**
     * all class data in pages
     * @param clazzQueryParamDTO
     * @return
     */
    List<ClazzDTO> getAll(ClazzQueryParamDTO clazzQueryParamDTO);

    /**
     * create class in database
     * @param clazzDTO
     */
    void create(ClazzDTO clazzDTO);

    /**
     * Delete class data by id
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
     * Update class data by id
     * @param clazzDTO
     */
    void update(ClazzDTO clazzDTO);
}
