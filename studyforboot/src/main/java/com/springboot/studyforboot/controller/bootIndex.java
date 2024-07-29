package com.springboot.studyforboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bootIndex {
    @RequestMapping("/boot")
    public String mapping(){
        return "Hello";
    }
}
