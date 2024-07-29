package com.example.controller;

import com.example.prjo.Result;
import com.example.prjo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class req_controller {
    @RequestMapping("/parm")
     public String simpleparm(String name,Integer age){
        System.out.println(name+":"+age);
        return "OK";
     }

     @RequestMapping("/Jsonreq")
    public Result JsonRequest(@RequestBody User user){
         System.out.println(user);
        return Result.success("copy");
     }
}
