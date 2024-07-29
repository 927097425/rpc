package com.example.tlias.service;


import com.example.tlias.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> selectAll();
    void deleteByid(Integer id);
    void insertDept(String name);
    void updateDeptName(Dept dept);
}
