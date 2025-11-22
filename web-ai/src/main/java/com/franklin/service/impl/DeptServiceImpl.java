package com.franklin.service.impl;

import com.franklin.dto.DeptDTO;
import com.franklin.exception.BusinessException;
import com.franklin.mapper.DeptMapper;
import com.franklin.service.DeptService;
import com.franklin.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/15
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {

    private final DeptMapper deptMapper;
    private final EmpService empService;

    @Override
    public List<DeptDTO> getAll() {
        return deptMapper.getAll();
    }

    @Override
    public void delete(Integer id) {
        if (empService.existsByDeptId(id)) {
            throw new BusinessException("Dept has emps, cannot be deleted");
        }
        deptMapper.delete(id);
    }

    @Override
    public void create(DeptDTO deptDto) {
        deptMapper.create(deptDto);
    }

    @Override
    public DeptDTO get(Integer id) {
        return deptMapper.get(id);
    }

    @Override
    public void update(DeptDTO deptDto) {
        deptMapper.update(deptDto);
    }
}
