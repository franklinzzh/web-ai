package com.franklin.service.impl;

import com.franklin.dto.ClazzCreateDTO;
import com.franklin.dto.ClazzDTO;
import com.franklin.dto.ClazzQueryParamDTO;
import com.franklin.dto.ClazzUpdateDTO;
import com.franklin.entity.PageResult;
import com.franklin.exception.BusinessException;
import com.franklin.mapper.ClazzMapper;
import com.franklin.service.ClazzService;
import com.franklin.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/20
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class ClazzServiceImpl implements ClazzService {

    private final ClazzMapper clazzMapper;

    private final EmpService empService;

    @Override
    public PageResult<ClazzDTO> getPage(ClazzQueryParamDTO clazzQueryParamDTO) {
        //设置分页参数 - PageHelper 自动拦截 query 增加 limit
        PageHelper.startPage(clazzQueryParamDTO.getPage(), clazzQueryParamDTO.getPageSize());
        //执行查询
        List<ClazzDTO> clazzDTOList = clazzMapper.getPage(clazzQueryParamDTO);
        PageInfo<ClazzDTO> pageInfo = new PageInfo<>(clazzDTOList);
        //封装结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList() );
    }

    @Override
    public void create(ClazzCreateDTO dto) {
        //check name unique
        if (this.existsByName(dto.getName())) {
            throw new BusinessException("Class Name already exists");
        }
        // check begin-end data logic
        if (dto.getEndDate().isBefore(dto.getBeginDate())) {
            throw new BusinessException("Class end date cannot be earlier than start date");
        }
        clazzMapper.create(dto);
    }

    @Override
    public void delete(Integer id) {
        //if there are students under this id's class, cannot delete it


        clazzMapper.delete(id);
    }

    @Override
    public ClazzDTO get(Integer id) {
        return clazzMapper.get(id);
    }

    @Override
    public void update(ClazzUpdateDTO dto) {
        //1. check business logic
        // check id existence
        if (!this.existsById(dto.getId())) {
            throw new BusinessException("Class ID not found");
        }
        if (!this.existsByName(dto.getName())) {
            throw new BusinessException("Class Name not found");
        }
        // check masterId existence
        Integer masterId = dto.getMasterId();
        //later create an existById method to just find whether the id is existed or not
        if (empService.get(masterId) == null) {
            throw new BusinessException("Emp data not found");
        }
        // check begin-end data logic
        if (dto.getEndDate().isBefore(dto.getBeginDate())) {
            throw new BusinessException("Class end date cannot be earlier than start date");
        }
        //2. update in mapper
        clazzMapper.update(dto);
    }

    @Override
    public List<ClazzDTO> getAll() {
        return clazzMapper.getAll();
    }

    @Override
    public boolean existsByName(String name) {
        return clazzMapper.existsByName(name);
    }

    @Override
    public boolean existsById(Integer id) {
        return clazzMapper.existsById(id);
    }

}
