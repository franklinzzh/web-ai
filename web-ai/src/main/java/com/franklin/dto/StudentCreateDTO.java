package com.franklin.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Auther: franklin
 * @Date: 2025/11/21
 * @Description:
 */
@Data
public class StudentCreateDTO {

    @NotEmpty(message = "name is required")
    private String name; //姓名

    @NotEmpty(message = "no is required")
    private String no; //序号

    @NotNull(message = "gender is required")
    private Integer gender; //性别 , 1: 男 , 2 : 女

    @NotEmpty(message = "phone is required")
    private String phone; //手机号

    @NotNull(message = "degree is required")
    private Integer degree; //最高学历, 1: 初中, 2: 高中 , 3: 大专 , 4: 本科 , 5: 硕士 , 6: 博士

    @NotNull(message = "class ID is required")
    private Integer clazzId; //班级ID

    // Optional
    private String idCard; //身份证号
    private Integer isCollege; //是否来自于院校, 1: 是, 0: 否
    private String address; //联系地址
    private LocalDate graduationDate; //毕业时间
}
