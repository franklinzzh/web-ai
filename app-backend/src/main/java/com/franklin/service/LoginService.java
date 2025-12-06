package com.franklin.service;

import com.franklin.dto.LoginRequestDTO;
import com.franklin.dto.LoginResponseDTO;

/**
 * @Auther: franklin
 * @Date: 2025/11/22
 * @Description:
 */
public interface LoginService {

    /**
     * Employee login
     * @param requestDTO
     * @return
     */
    LoginResponseDTO login(LoginRequestDTO requestDTO);
}
