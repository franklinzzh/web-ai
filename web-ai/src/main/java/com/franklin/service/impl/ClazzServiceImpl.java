package com.franklin.service.impl;

import com.franklin.dto.ClazzDTO;
import com.franklin.dto.ClazzQueryParamDTO;
import com.franklin.entity.PageResult;
import com.franklin.exception.BusinessException;
import com.franklin.mapper.ClazzMapper;
import com.franklin.service.ClazzService;
import com.franklin.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public PageResult<ClazzDTO> getAll(ClazzQueryParamDTO clazzQueryParamDTO) {
        //设置分页参数 - PageHelper 自动拦截 query 增加 limit
        PageHelper.startPage(clazzQueryParamDTO.getPage(), clazzQueryParamDTO.getPageSize());
        //执行查询
        List<ClazzDTO> clazzDTOList = clazzMapper.getAll(clazzQueryParamDTO);
        PageInfo<ClazzDTO> pageInfo = new PageInfo<>(clazzDTOList);
        //封装结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList() );
    }

    @Override
    public void create(ClazzDTO clazzDTO) {
        Integer masterId = clazzDTO.getMasterId();
        if (masterId == null || empService.get(masterId) == null) {
            throw new BusinessException("Class masterId is illegal");
        }
        clazzDTO.setCreateTime(LocalDateTime.now());
        clazzDTO.setUpdateTime(LocalDateTime.now());
        clazzMapper.create(clazzDTO);
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.delete(id);
    }

    @Override
    public ClazzDTO get(Integer id) {
        return clazzMapper.get(id);
    }

    @Override
    public void update(ClazzDTO clazzDTO) {
        Integer masterId = clazzDTO.getMasterId();
        //later create an existById method to just find whether the id is exist or not
        if (masterId == null || empService.get(masterId) == null) {
            throw new BusinessException("Class masterId is illegal");
        }
        if (clazzDTO.getEndDate().isBefore(clazzDTO.getBeginDate())) {
            throw new BusinessException("Class end date cannot be earlier than start date");
        }
        clazzDTO.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazzDTO);
    }
}
