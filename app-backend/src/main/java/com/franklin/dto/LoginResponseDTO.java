package com.franklin.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: franklin
 * @Date: 2025/11/22
 * @Description:
 */
@Data
@NoArgsConstructor
public class LoginResponseDTO {

    private Integer id;
    private String username;
    private String name;
    private String token;
}
