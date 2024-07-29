package com.example.tlias.service.Imp;

import com.example.tlias.mapper.DeptMapper;
import com.example.tlias.mapper.EmpMapper;
import com.example.tlias.service.DeptService;
import com.example.tlias.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptServiceA implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    EmpMapper empMapper;
    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }

    @Transactional
    @Override
    public void deleteByid(Integer id) {
        deptMapper.deleteByid(id);
        empMapper.deleteByDeptid(id);
        return;
    }

    @Override
    public void insertDept(String name) {
        deptMapper.insertDept(name);
        return;
    }

    @Override
    public void updateDeptName(Dept dept) {
        deptMapper.updateDept(dept);
        return;
    }
}
