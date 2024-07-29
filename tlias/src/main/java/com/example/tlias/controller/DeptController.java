package com.example.tlias.controller;

import com.example.tlias.pojo.Dept;
import com.example.tlias.pojo.Result;
import com.example.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;
    @GetMapping("/depts")
    public Result getDepts(){
        log.info("查询全部部门数据");
        List<Dept> depts = deptService.selectAll();
        return Result.success(depts);
    }
    @DeleteMapping("/depts/{id}")
    public Result deleteByid(@PathVariable Integer id){
        log.info("删除部门,id 为 "+id);
        deptService.deleteByid(id);

        return Result.success();
    }
    @PostMapping(value  ="/depts" )
    public Result insertDept(@RequestBody Dept dept){
        log.info("添加部门："+dept.getName());
        deptService.insertDept(dept.getName());
        return Result.success();
    }
    @PutMapping("/depts")
    public Result updateDeptName(@RequestBody Dept dept){
        log.info("待修改部门的id: " +dept.getId()+"修改后的部门名称:"+dept.getName());
        deptService.updateDeptName(dept);
        return Result.success();
    }

}
