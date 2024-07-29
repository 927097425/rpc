package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    EmpMapper empMapper;
    @Test
    public  void test() {
        empMapper.delete(15);
    }

    @Test
    public void test4select(){

        Short gender = 1;
        List<Emp> empList = empMapper.select(null,gender,null,null);
        System.out.println(empList);
    }

}
