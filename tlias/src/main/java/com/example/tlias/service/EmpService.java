package com.example.tlias.service;


import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.PageBean;
import com.example.tlias.pojo.empSearch;

import java.util.List;

public interface EmpService {
    PageBean searchByMsg(empSearch empsearch);
    void deleteByids(List<Integer> ids);
    void insertByMsg(Emp emp);
    Emp selectByid(Integer id);
    void changeByEmp(Emp emp);
}
