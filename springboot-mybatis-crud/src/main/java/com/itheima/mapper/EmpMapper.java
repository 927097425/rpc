package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {

    public void delete(Integer id);

    public List<Emp> select (String name, Short gender, LocalDate begin, LocalDate end);
}
