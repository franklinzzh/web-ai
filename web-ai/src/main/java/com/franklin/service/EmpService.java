package com.franklin.service;

import com.franklin.dto.EmpQueryParam;
import com.franklin.entity.Emp;
import com.franklin.entity.PageResult;

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
    PageResult<Emp> getAll(EmpQueryParam empQueryParam);

    /**
     * 添加员工
     * @param emp
     */
    void create(Emp emp);
}
