package com.franklin.service.impl;

import com.franklin.dto.EmpQueryParam;
import com.franklin.entity.Emp;
import com.franklin.entity.EmpExpr;
import com.franklin.entity.PageResult;
import com.franklin.mapper.EmpExprMapper;
import com.franklin.mapper.EmpMapper;
import com.franklin.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/16
 * @Description: Employee service implement
 */
@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    private final EmpExprMapper empExprMapper;

    @Override
    public PageResult getAll(EmpQueryParam empQueryParam) {
        //1. 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        //2. 执行查询
        List<Emp> empList =  empMapper.getAll(empQueryParam);
        PageInfo<Emp> pageInfo = new PageInfo<>(empList);
        //3. 封装结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void create(Emp emp) {
        //fill basic info
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        // create emp data
        Integer id = empMapper.insert(emp);

        int i = 1/0;
        // create emp experience data - in batch
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr ->  empExpr.setEmpId(id));
            empExprMapper.insertBatch(exprList);
        }
    }

    @Transactional
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
        empExprMapper.delete(ids);
    }
}
