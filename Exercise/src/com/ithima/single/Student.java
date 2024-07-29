package com.ithima.single;

public class Student {
    private String name;
    public static Student st ;

    {
        name = "张三";
    }
    private Student(){

    }//构造函数私有化
    public static Student getInstance() {
        if (st == null) {
            synchronized (Student.class){
                if (st == null) st = new Student();//双锁结构线程安全
            }
        }
        return st;
    }//线程安全的懒汉式单例模式

    public String getName() {
        return name;
    }
}
