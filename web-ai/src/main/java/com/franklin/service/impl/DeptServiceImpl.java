package com.franklin.service.impl;

import com.franklin.entity.Dept;
import com.franklin.mapper.DeptMapper;
import com.franklin.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List<Dept> getAll() {
        return deptMapper.getAll();
    }

    @Override
    public Dept delete(Integer id) {
        Dept dept = deptMapper.get(id);
        deptMapper.delete(id);
        return dept;
    }

    @Override
    public void create(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.create(dept);
    }

    @Override
    public Dept get(Integer id) {
        return deptMapper.get(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
