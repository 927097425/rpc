package com.ithima.Properties;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        File f = new File("src\\com\\ithima\\Properties\\user.properties");
        Properties pro = new Properties();
        pro.setProperty("张三","20");
        pro.put("李四","20");
        try(
                Writer w = new FileWriter(f);
                ) {
            pro.store(w,"This is a User list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
