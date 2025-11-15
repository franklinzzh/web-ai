package com.franklin.controller;

import com.franklin.common.Result;
import com.franklin.entity.Dept;
import com.franklin.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/15
 * @Description:
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/depts")
    public Result list(){

        System.out.println("查询部门全部数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
}
