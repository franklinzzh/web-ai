package com.franklin.mapper;

import com.franklin.entity.Emp;
import com.franklin.entity.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/16
 * @Description:
 */
@Mapper
public interface EmpMapper {

    @Select("select count(*) from emp;")
    Long count();
    //-- 查询 !所有的! 员工信息，如果员工关联了部门，也要查询出部门名称
    // 注意修改返回 column 名称为 entity 的对应名称 "deptName"
    @Select("select e.*, d.name as deptName from emp e left join dept d on e.dept_id = d.id limit #{start}, #{pageSize};")
    List<Emp> list(Integer start, Integer pageSize);
}
