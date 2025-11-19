package com.franklin.service.impl;

import com.franklin.dto.EmpDto;
import com.franklin.dto.EmpQueryParam;
import com.franklin.entity.Emp;
import com.franklin.entity.EmpExpr;
import com.franklin.entity.PageResult;
import com.franklin.mapper.EmpExprMapper;
import com.franklin.mapper.EmpMapper;
import com.franklin.service.EmpService;
import com.franklin.util.Result;
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
        List<EmpDto> empList =  empMapper.getAll(empQueryParam);
        PageInfo<EmpDto> pageInfo = new PageInfo<>(empList);
        //3. 封装结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void create(EmpDto empDto) {
        //fill basic info
        empDto.setCreateTime(LocalDateTime.now());
        empDto.setUpdateTime(LocalDateTime.now());
        // create emp data
        Integer id = empMapper.insert(empDto);

        // create emp experience data - in batch
        List<EmpExpr> exprList = empDto.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr ->  empExpr.setEmpId(id));
            empExprMapper.insertBatch(exprList);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
        empExprMapper.delete(ids);
    }

    @Override
    public Result get(Integer id) {
        EmpDto empDto = empMapper.select(id);
        if (empDto == null) {
            return Result.error("No emp found with id: " + id);
        }
        return Result.success(empDto);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result update(Integer id, EmpDto empDto) {
        //1. error check
        EmpDto empDB = empMapper.select(id);
        if (empDB == null) {
            return Result.error("No emp found with id: " + id);
        }
        //forcely set the id, json data could be modified
        empDto.setId(id);

        //2. update emp data
        empDto.setUpdateTime(LocalDateTime.now());
        empMapper.update(empDto);

        //3. update emp_expr data
        //delete old experience
        empExprMapper.delete(List.of(empDto.getId()));
        //insert updated experience
        List<EmpExpr> empExprList = empDto.getExprList();
        if (!CollectionUtils.isEmpty(empExprList)) {
            empExprList.forEach(empExpr -> empExpr.setId(id));
            empExprMapper.insertBatch(empExprList);
        }
        //4. return result
        return Result.success();
    }
}
