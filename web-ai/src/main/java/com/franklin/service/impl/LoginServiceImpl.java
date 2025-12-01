package com.franklin.service.impl;

import com.franklin.dto.LoginRequestDTO;
import com.franklin.dto.LoginResponseDTO;
import com.franklin.exception.BusinessException;
import com.franklin.mapper.LoginMapper;
import com.franklin.service.LoginService;
import com.franklin.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Auther: franklin
 * @Date: 2025/11/22
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginMapper loginMapper;

    @Override
    public LoginResponseDTO login(LoginRequestDTO requestDTO) {
        LoginResponseDTO responseDTO = loginMapper.login(requestDTO);
        System.out.println(responseDTO);
        if (responseDTO == null) {
            throw new BusinessException("UserName or Password incorrect");
        }
        String token  = JwtUtil.generateToken(responseDTO.getId());
        responseDTO.setToken(token);
        System.out.println(responseDTO);
        return responseDTO;
    }
}
