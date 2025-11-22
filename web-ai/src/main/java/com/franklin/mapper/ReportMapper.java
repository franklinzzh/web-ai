package com.franklin.mapper;

import com.franklin.dto.GenderOptionDTO;
import com.franklin.dto.StudentDegreeDTO;
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

    /**
     *
     * @return List<Map<String, Object>>
     */
    @MapKey("pos")
    List<Map<String, Object>> getEmpJobData();


    List<GenderOptionDTO> getEmpGenderData();

    /**
     * Fetch each class student count
     * @return
     */
    @MapKey("name")
    List<Map<String, Object>> fetchStudentCount();

    /**
     * Fetch student degree and count
     * @return
     */
    List<StudentDegreeDTO> fetchStudentDegree();
}
