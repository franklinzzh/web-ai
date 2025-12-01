package com.franklin.mapper;

import com.franklin.entity.File;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: franklin
 * @Date: 2025/11/30
 * @Description:
 */
@Mapper
public interface FileMapper {

    void create(File file);
}
