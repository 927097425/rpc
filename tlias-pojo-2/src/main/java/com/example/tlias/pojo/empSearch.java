package com.example.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class empSearch {
    String name;
    Integer gender;
    LocalDate begin;
    LocalDate end;
    Integer page;
    Integer pageSize;

}
