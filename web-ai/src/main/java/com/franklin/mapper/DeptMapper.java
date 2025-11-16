package com.franklin.mapper;

import com.franklin.entity.Dept;
import org.apache.ibatis.annotations.*;

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
    List<Dept> getAll();

    /**
     *  删除指定id部门
     */
    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    /**
     * 增加指定部门
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void create(Dept dept);

    /**
     * 根据id查询指定部门
     * @param id
     * @return id部门
     */
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept get(Integer id);

    /**
     * 更新指定部门
     * @param dept
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
