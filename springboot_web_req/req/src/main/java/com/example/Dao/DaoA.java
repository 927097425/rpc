package com.example.Dao;

import com.example.prjo.Emp;
import com.example.utils.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DaoA implements Dao{

    @Override
    public List<Emp> dataAccess() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp>  empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
