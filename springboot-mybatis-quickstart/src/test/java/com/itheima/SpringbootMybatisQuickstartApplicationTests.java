package com.itheima;

import com.itheima.mapper.Usermapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    private Usermapper usermapper;
    @Test
    public void testUser(){
        List<User> userList = usermapper.list();
        userList.stream().forEach(
                user -> {
                    System.out.println(user);
                });
    }

}
