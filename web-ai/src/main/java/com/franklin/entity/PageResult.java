package com.franklin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/16
 * @Description: 返回前端分页结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {
    private Long total; //总记录数
    private List rows; //当前页数据列表
}
