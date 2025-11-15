package com.franklin.mapper;

import com.franklin.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/15
 * @Description:
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门
     * @return
     */
    @Select("select * from dept order by update_time desc")
    List<Dept> findAll();
}
