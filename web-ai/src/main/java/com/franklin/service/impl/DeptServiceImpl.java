package com.franklin.service.impl;

import com.franklin.entity.Dept;
import com.franklin.mapper.DeptMapper;
import com.franklin.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/15
 * @Description:
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
