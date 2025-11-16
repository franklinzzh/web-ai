package com.franklin.controller;

import com.franklin.common.Result;
import com.franklin.entity.Dept;
import com.franklin.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/15
 * @Description:
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门全部数据 GET http://localhost:8080/depts
     *
     * @param
     * @return
     * @author franklin
     * @date 11/16/25
     */
    @GetMapping
    public Result getAll(){
        System.out.println("查询部门全部数据");
        List<Dept> deptList = deptService.getAll();
        return Result.success(deptList);
    }

    /**
     * 删除id指定部门 DELETE http://localhost:8080/depts?id=1
     * @param id
     * @return
     */
    @DeleteMapping
    public Result delete(@RequestParam("id") Integer id) {
        if (id == null) {
            return Result.error("非法id");
        }
        Dept dept = deptService.delete(id);
        return dept == null ? Result.error("Dept not exist") : Result.success(dept);
    }

    /**
     * 增加指定部门 - POST - http://localhost:8080/depts 请求参数：{"name":"研发部"}
     *
     * @param dept
     * @return Result
     * @author franklin
     * @date 11/16/25
     */
    @PostMapping
    public Result create(@RequestBody Dept dept) {
        if (dept == null) {
            return Result.error("incorrect dept data");
        }

        deptService.create(dept);
        return Result.success();
    }

    /**
     * 查询指定id部门 - GET http://localhost:8080/depts/1
     *
     * @param
     * @return
     * @author franklin
     * @date 11/16/25
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        if (id == null) {
            return Result.error("非法id");
        }
        Dept dept = deptService.get(id);
        return dept == null ? Result.error("Dept not exist") : Result.success(dept);
    }

    /**
     * 修改指定部门 - PUT - http://localhost:8080/depts 请求参数：{"id": 1, "name": "研发部"}
     *
     * @param 
     * @return 
     * @author franklin
     * @date 11/16/25
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        if (dept == null) {
            return Result.error("incorrect dept");
        }
        deptService.update(dept);
        return Result.success();
    }


}
