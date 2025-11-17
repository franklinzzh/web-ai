package com.franklin.mapper;

import com.franklin.dto.EmpQueryParam;
import com.franklin.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * EmpMapper
 *
 * @Auther: franklin
 * @Date: 2025/11/16
 * @Description: MyBatis mapper interface for employee database operations.
 *
 *
 */
@Mapper
public interface EmpMapper {

    /**
     * 员工列表查询
     * @param empQueryParam
     * @return
     */
    //-- 查询 !所有的! 员工信息，如果员工关联了部门，也要查询出部门名称
    // 注意修改返回 column 名称为 entity 的对应名称 "deptName"
    List<Emp> getAll(EmpQueryParam empQueryParam);

    /**
     * 添加员工
     * @param emp
     */
    Integer insert(Emp emp);
}
