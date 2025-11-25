package com.franklin.service.impl;

import com.franklin.dto.*;
import com.franklin.entity.Emp;
import com.franklin.entity.EmpExpr;
import com.franklin.entity.PageResult;
import com.franklin.mapper.EmpExprMapper;
import com.franklin.mapper.EmpMapper;
import com.franklin.service.EmpService;
import com.franklin.service.LoginService;
import com.franklin.util.JwtUtil;
import com.franklin.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    private final LoginService loginService;

    @Override
    public PageResult getAll(EmpQueryParam empQueryParam) {
        //1. 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        //2. 执行查询
        List<EmpDto> empList =  empMapper.getAllPaged(empQueryParam);
        PageInfo<EmpDto> pageInfo = new PageInfo<>(empList);
        //3. 封装结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public List<Emp> getAll() {
        return empMapper.getAll();
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void create(EmpCreateDTO createDTO) {
        // create emp data
        Emp emp = this.convert(createDTO);
        Integer id = empMapper.insert(emp);

        // create emp experience data - in batch
        List<EmpExprCreateDTO> exprList = createDTO.getExprList();

        if (!CollectionUtils.isEmpty(exprList)) {
            List<EmpExpr> entityList = exprList.stream()
                    .map(dto -> {
                        EmpExpr e = new EmpExpr();
                        e.setEmpId(id);
                        e.setCompany(dto.getCompany());
                        e.setBegin(dto.getBegin());
                        e.setEnd(dto.getEnd());
                        return e;
                    }).collect(Collectors.toList());
            empExprMapper.insertBatch(entityList);
        }
    }

    private Emp convert(EmpCreateDTO dto) {
        Emp emp = new Emp();
        emp.setUsername(dto.getUsername());
        emp.setName(dto.getName());
        emp.setGender(dto.getGender());
        if (dto.getPhone() != null) {
            emp.setPhone(dto.getPhone());
        }
        if (dto.getJob() != null) {
            emp.setJob(dto.getJob());
        }
        if (dto.getSalary() != null) {
            emp.setSalary(dto.getSalary());
        }
        if (dto.getImage() != null) {
            emp.setImage(dto.getImage());
        }
        if (dto.getEntryDate() != null) {
            emp.setEntryDate(dto.getEntryDate());
        }
        if (dto.getDeptId() != null) {
            emp.setDeptId(dto.getDeptId());
        }
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        return emp;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
        empExprMapper.delete(ids);
    }

    @Override
    public EmpDto get(Integer id) {
        return empMapper.select(id);
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

    @Override
    public boolean existsByDeptId(Integer deptId) {
        return empMapper.existsByDeptId(deptId);
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO requestDTO) {
        LoginResponseDTO response = loginService.login(requestDTO);
        String token  = JwtUtil.generateToken(response.getId(), response.getUsername());
        response.setToken(token);
        System.out.println(response);
        return response;
    }
}
