package com.ithima.Series;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;

public class Test {
    public static void main(String[] agrs){
        User u1 = new User("张三","927097425","524628796",20);
        ArrayList<User> user_list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            user_list.add(u1);
        }

        try (
                OutputStream os = new FileOutputStream("User_List.txt");
                ObjectOutputStream oos = new ObjectOutputStream(os);
                InputStream is = new FileInputStream("User_List.txt");
                ObjectInputStream ois = new ObjectInputStream(is);
                ){
            oos.writeObject(user_list);
            System.out.println("序列化对象完成");

            ArrayList<User> u1_unserial = (ArrayList<User>)ois.readObject();
            System.out.println(u1_unserial);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
