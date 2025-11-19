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
     * 员工列表查询
     * @return List<Emp>
     */
    PageResult<EmpDto> getAll(EmpQueryParam empQueryParam);

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
    Result get(Integer id);

    /**
     * 更新员工信息
     * @param id
     * @param empDto
     */
    Result update(Integer id, EmpDto empDto);
}
