package com.franklin.controller;

import com.franklin.dto.LoginRequestDTO;
import com.franklin.dto.LoginResponseDTO;
import com.franklin.service.LoginService;
import com.franklin.util.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: franklin
 * @Date: 2025/11/22
 * @Description:
 */
@Slf4j
@RestController
@RequiredArgsConstructor

public class LoginController {

    private final LoginService loginService;

    /**
     * Employee login
     * @param requestDTO
     * @return
     */
    @PostMapping("/login")
    public Result<LoginResponseDTO> login(@RequestBody LoginRequestDTO requestDTO) {
        log.info("Post /login - Login: {}", requestDTO);
        LoginResponseDTO responseDTO = loginService.login(requestDTO);
        return Result.success(responseDTO);
    }

}
