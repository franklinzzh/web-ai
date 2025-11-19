package com.franklin.mapper;

import com.franklin.dto.EmpDto;
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
    List<EmpDto> getAll(EmpQueryParam empQueryParam);

    /**
     * 添加员工
     * @param empDto
     */
    Integer insert(EmpDto empDto);

    /**
     * 删除员工
     * @param ids
     * @return
     */
    void delete(List<Integer> ids);

    /**
     * 根据Id查询员工信息
     * @param id
     * @return Emp
     */
    EmpDto select(Integer id);

    /**
     * 更新员工信息
     * @param empDto
     */
    void update(EmpDto empDto);
}
