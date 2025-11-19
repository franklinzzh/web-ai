package com.franklin.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Auther: franklin
 * @Date: 2025/11/19
 * @Description:
 */
@Mapper
public interface ReportMapper {

    @MapKey("pos")
    List<Map<String, Object>> getEmpJobData();
}
