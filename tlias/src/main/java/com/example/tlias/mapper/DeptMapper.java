package com.example.tlias.mapper;

import com.example.tlias.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    public List<Dept> selectAll();
    public void deleteByid(Integer id);
    public void insertDept(String deptName);
    public void updateDept(Dept dept);
}
