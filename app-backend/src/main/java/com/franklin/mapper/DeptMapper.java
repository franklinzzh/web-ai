package com.franklin.mapper;

import com.franklin.dto.DeptDTO;
import com.franklin.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/15
 * @Description:
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门
     * @return
     */
    List<DeptDTO> getAll();

    /**
     *  删除指定id部门
     */

    void delete(Integer id);

    /**
     * 增加指定部门
     * @param deptDto
     */
    void create(DeptDTO deptDto);

    /**
     * 根据id查询指定部门
     * @param id
     * @return id部门
     */
    DeptDTO get(Integer id);

    /**
     * 更新指定部门
     * @param deptDto
     */
    void update(DeptDTO deptDto);
}
