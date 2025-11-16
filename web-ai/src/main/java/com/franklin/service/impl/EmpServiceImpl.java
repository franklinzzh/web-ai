package com.franklin.service.impl;

import com.franklin.entity.Emp;
import com.franklin.entity.PageResult;
import com.franklin.mapper.EmpMapper;
import com.franklin.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/16
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    @Override
    public PageResult page(Integer page, Integer pageSize) {
        //get all emps count
        Long total = empMapper.count();

        //get the emps on that page
        Integer start = page - 1;
        List<Emp> empList =  empMapper.list(start, pageSize);
        return new PageResult(total, empList);
    }
}
