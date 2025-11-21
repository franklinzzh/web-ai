package com.franklin.service.impl;

import com.franklin.dto.StudentCreateDTO;
import com.franklin.dto.StudentQueryParamDTO;
import com.franklin.dto.StudentUpdateDTO;
import com.franklin.entity.PageResult;
import com.franklin.entity.Student;
import com.franklin.exception.BusinessException;
import com.franklin.mapper.StudentMapper;
import com.franklin.service.StudentService;
import com.franklin.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/21
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final Integer VALID_PHONE_NUM = 11;

    @Override
    public PageResult<Student> getPage(StudentQueryParamDTO param) {
        //1. set up page limit
        PageHelper.startPage(param.getPage(), param.getPageSize());
        // remove white-spaced string
        String name = param.getName();
        if (name != null) {
            name.trim();
        }
        param.setName(name);
        // package into PageInfo
        List<Student> studentList=  studentMapper.getPage(param);
        PageInfo<Student> pageInfo = new PageInfo<>(studentList);
        //2. put into the pageResult entity with total and studentList
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public void create(StudentCreateDTO createDTO) {
        if (createDTO.getPhone().length() != VALID_PHONE_NUM) {
            throw new BusinessException("Invalid Phone Number");
        }
        studentMapper.create(createDTO);
    }

    @Override
    public Student get(Integer id) {
        if (id == null) {
            throw new BusinessException("ID can not be empty");
        }
        return studentMapper.get(id);
    }

    @Override
    public void update(StudentUpdateDTO updateDTO) {
        //1. check id
        if (!this.existsById(updateDTO.getId())) {
            throw new BusinessException("ID not found");
        }
        //2. check if new name has been used
        String updateName = updateDTO.getName();
        String originName = this.getName(updateDTO.getId());
        if (updateName != originName && this.existsByName(updateName)) {
            throw new BusinessException("Name already in use");
        }
        //3. update in sql
        studentMapper.update(updateDTO);
    }

    @Override
    public boolean existsByClazzId(Integer id) {
        return studentMapper.existsByClazzId(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return studentMapper.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return studentMapper.existsByName(name);
    }

    @Override
    public String getName(Integer id) {
        return studentMapper.getName(id);
    }


}
