package com.ithima.father_son;

public class Test {
    public static void main(String[] arg){
        Teacher t = new Teacher("张三",20,"Java");
        System.out.println(t);
        People p1 = new Teacher();//只会获取其中父类有的部分
        System.out.println(p1);
    }
}
