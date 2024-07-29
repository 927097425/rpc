package com.example.tlias.service.Imp;


import com.example.tlias.utils.JwtUtils;
import com.example.tlias.mapper.LoginMapper;
import com.example.tlias.pojo.Emp;
import com.example.tlias.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceA implements LoginService {
    @Autowired
    LoginMapper loginmapper;
    @Override
    public String login(String username, String password) {
        List<Emp>  emp = loginmapper.login(username,password);
        if(emp.size()!=0){
            Map<String,Object> claims = new HashMap<>();
            claims.put("username",username);
            claims.put("password",password);
            String jwt = JwtUtils.generateJwt(claims);
            return jwt;
        }
        else {
            return null;
        }

    }
}
