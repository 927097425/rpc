package com.ithima.single;

public class Test {
    public static void main(String[] args){
        Student st1 = Student.getInstance();
        Student st2 = Student.getInstance();
        System.out.println(st1);
        System.out.println(st2);

        Student_operator.print_name(st1);
    }
}
