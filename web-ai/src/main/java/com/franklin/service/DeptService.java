package com.franklin.service;

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
     * @return List<Dept>
     */
    List<Dept> findAll();
}
