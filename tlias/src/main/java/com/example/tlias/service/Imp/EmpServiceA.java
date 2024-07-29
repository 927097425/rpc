package com.example.tlias.service.Imp;

import com.example.tlias.mapper.EmpMapper;
import com.example.tlias.service.EmpService;
import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.PageBean;
import com.example.tlias.pojo.empSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceA implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean searchByMsg(empSearch empsearch) {
        empsearch.setPage((empsearch.getPage()-1)*empsearch.getPageSize());
        return new PageBean(empMapper.count(),empMapper.searchByMsg(empsearch));
    }

    @Override
    public void deleteByids(List<Integer> ids) {
        empMapper.deleteByid(ids);
        return;
    }

    @Override
    public void insertByMsg(Emp emp) {
        empMapper.insertByMsg(emp);
        return;
    }

    @Override
    public Emp selectByid(Integer id) {
        return empMapper.selectByid(id);
    }

    @Override
    public void changeByEmp(Emp emp) {
        empMapper.updateByEmp(emp);
        return;
    }
}
