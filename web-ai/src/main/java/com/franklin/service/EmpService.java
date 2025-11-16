package com.franklin.service;

import com.franklin.entity.Emp;
import com.franklin.entity.PageResult;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/16
 * @Description:
 */
public interface EmpService {

    /**
     * 获取所有员工信息
     * @return List<Emp>
     */
    PageResult page(Integer page, Integer pageSize);
}
