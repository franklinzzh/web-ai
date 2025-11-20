package com.franklin.service;

import com.franklin.dto.EmpDto;
import com.franklin.dto.EmpQueryParam;
import com.franklin.entity.Emp;
import com.franklin.entity.PageResult;
import com.franklin.util.Result;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/16
 * @Description: Employee service
 */
public interface EmpService {

    /**
     * Get all employees - PageHelper
     * @return a pagination result including total employee numbers and employee data
     */
    PageResult<EmpDto> getAll(EmpQueryParam empQueryParam);

    /**
     * Get all employees
     * @return List of all employees
     */
    List<Emp> getAll();
    /**
     * 添加员工
     * @param empDto
     */
    void create(EmpDto empDto);

    /**
     * 删除员工
     * @param ids
     * @return
     */
    void delete(List<Integer> ids);

    /**
     * 根据Id查询员工
     * @param id
     * @return Emp
     */
    EmpDto get(Integer id);

    /**
     * 更新员工信息
     * @param id
     * @param empDto
     */
    Result update(Integer id, EmpDto empDto);
}
