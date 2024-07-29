package com.ithima.Student_Info;
import java.util.ArrayList;
public interface Realized {
    void print_Info(ArrayList<Student> s);//都省略了public abstract
    void print_average_score(ArrayList<Student> s);
    static void commom_method(){
        System.out.println("这是个通用接口的定义方法");//省略了public但不是抽象类
    }
}
