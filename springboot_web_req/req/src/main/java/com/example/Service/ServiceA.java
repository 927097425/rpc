package com.example.Service;

import com.example.Dao.Dao;
import com.example.Dao.DaoA;
import com.example.prjo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ServiceA implements Service{
    @Autowired
    Dao ado ;
    @Override
    public List<Emp> Transfer() {
        List<Emp> empList = ado.dataAccess();
        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else {
                emp.setGender("女");
            }

            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
