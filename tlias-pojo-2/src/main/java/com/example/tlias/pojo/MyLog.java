package com.example.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyLog {
    private Integer id;
    private String username;
    private LocalDateTime operatedTime;
    private String className;
    private String methodName;
    private String methodParms;
    private String result;
    private Long excutedTime;


}
