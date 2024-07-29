package com.example.controller;

import com.example.Service.Service;
import com.example.Service.ServiceA;
import com.example.prjo.Emp;
import com.example.prjo.Result;
import com.example.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.XMLFormatter;

@RestController
public class EmpController {
    @Autowired
    Service service;
    @RequestMapping("/listEmp")
    public Result list(){


        List<Emp> empList = service.Transfer();

        return Result.success(empList);
    }

}
