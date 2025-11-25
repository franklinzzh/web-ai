package com.franklin.dto;

import com.franklin.entity.EmpExpr;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/25
 * @Description:
 */
@Data
public class EmpCreateDTO {

    @NotEmpty
    private String username; //用户名

    @NotEmpty
    private String name; //姓名

    @NotNull
    private Integer gender; //性别, 1:男, 2:女

    // Optional
    private String phone; //手机号
    private Integer job; //职位, 1:班主任,2:讲师,3:学工主管,4:教研主管,5:咨询师
    private Integer salary; //薪资
    private String image; //头像

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate entryDate; //入职日期
    private Integer deptId; //关联的部门ID

    //封装员工工作经验
    private List<EmpExprCreateDTO> exprList;
}
