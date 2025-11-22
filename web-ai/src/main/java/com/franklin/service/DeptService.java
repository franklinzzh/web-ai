package com.franklin.service;

import com.franklin.dto.DeptDTO;
import com.franklin.entity.Dept;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/15
 * @Description:
 */
public interface DeptService {
    /**
     * 返回所有dept数据
     * @return a list of Dept
     */
    List<DeptDTO> getAll();

    /**
     * 根据id删除指定dept
     * @param id
     * @return dept
     */
    void delete(Integer id);

    /**
     * 根据数据增加指定部门
     * @param deptDto
     */
    void create(DeptDTO deptDto);

    /**
     * 根据id查询指定部门
     * @param id
     * @return dept
     */
    DeptDTO get(Integer id);

    /**
     * 更新指定部门
     * @param deptDto
     */
    void update(DeptDTO deptDto);

}
