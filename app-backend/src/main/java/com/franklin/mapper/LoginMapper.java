package com.franklin.mapper;

import com.franklin.dto.LoginRequestDTO;
import com.franklin.dto.LoginResponseDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: franklin
 * @Date: 2025/11/22
 * @Description:
 */
@Mapper
public interface LoginMapper {

    /**
     * Employee login
     * @param requestDTO
     * @return
     */
    LoginResponseDTO login(LoginRequestDTO requestDTO);
}
