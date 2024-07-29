package com.example.tlias.controller;

import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.PageBean;
import com.example.tlias.pojo.Result;
import com.example.tlias.pojo.empSearch;
import com.example.tlias.service.EmpService;
import com.example.tlias.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    EmpService empService;
    @Autowired
    AliOSSUtils aliOSSUtils;
    @GetMapping("/emps")
    public Result selectMsg(empSearch empsearch){
        log.info("查询员工信息: "+empsearch.getPage()+"记录数："+empsearch.getPageSize());
        PageBean data = empService.searchByMsg(empsearch);
        return Result.success(data);
    }
    @DeleteMapping("/emps/{ids}")
    public Result deleteByids(@PathVariable List<Integer> ids){
        log.info("删除员工数据"+ids);
        empService.deleteByids(ids);
        return Result.success();
    }
    @PostMapping("/emps")
    public Result insertByMsg(@RequestBody Emp emp){
        log.info("插入员工数据");
        empService.insertByMsg(emp);
        return Result.success();
    }
    @PostMapping("/upload")
    public Result uploadFile(@RequestParam MultipartFile image) throws Exception{
        log.info("上传图片到阿里云中...");
        String url = aliOSSUtils.upload(image);
        log.info("上传成功");
        return Result.success(url);
    }
    @GetMapping("/emps/{id}")
    public Result selectByid(@PathVariable Integer id){
        log.info("查询信息中"+id);
        return Result.success(empService.selectByid(id));
    }
    @PutMapping("/emps")
    public Result changeByEmp(@RequestBody Emp emp){
        log.info("正在修改员工数据"+emp.getId());
        empService.changeByEmp(emp);

        return Result.success();
    }

}
