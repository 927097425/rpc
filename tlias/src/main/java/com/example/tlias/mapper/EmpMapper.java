package com.example.tlias.mapper;

import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.empSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    public List<Emp> searchByMsg(empSearch empsearch);
    public Integer count();

    public void deleteByid(List<Integer> ids);
    public void insertByMsg(Emp emp);

    public Emp selectByid(Integer id);
    public void updateByEmp(Emp emp);

    public void deleteByDeptid(Integer deptId);
}
