package com.example.tlias.mapper;

import com.example.tlias.pojo.MyLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface loggerMapper {
    void insertByLogger(MyLog mylog);

}
