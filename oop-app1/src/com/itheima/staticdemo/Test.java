package com.itheima.staticdemo;

public class Test {
    public static void main() {
        Student.name = "圆滑";

        Student s1 = new Student();
        s1.name = "马冬梅";

        Student s2 = new Student();
        s2.name = "秋雅";
        System.out.println(s1.name);
        return;
    }
}
