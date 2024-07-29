package com.ithima.staticdemo;

public class Test {
    public static void main(String[] arg){
        Student.name ="原话";

        Student s1 = new Student();
        s1.name = "你好";

        Student s2 = new Student();
        s2.name = "秋雅";

        System.out.println(s1.name);
        System.out.println(Student.name);
    }
}
