package com.franklin.mapper;

import com.franklin.dto.ClazzCreateDTO;
import com.franklin.dto.ClazzDTO;
import com.franklin.dto.ClazzQueryParamDTO;
import com.franklin.dto.ClazzUpdateDTO;
import com.franklin.entity.Clazz;
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
    List<ClazzDTO> getPage(ClazzQueryParamDTO clazzQueryParamDTO);

    /**
     * create class in database
     * @param dto
     */
    void create(ClazzCreateDTO dto);

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
     * @param dto
     */
    void update(ClazzUpdateDTO dto);

    /**
     * Get all class data
     */
    List<ClazzDTO> getAll();

    /**
     * find name exist in class or not
     * @param name
     * @return exist name: true
     *         not exist name : false
     */
    Boolean existsByName(String name);

    Boolean existsById(Integer id);
}
