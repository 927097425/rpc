package com.ithima.Abstract_templete;

public abstract class templates {
    public final void write(){
        System.out.println("《标题》");
        Write_mid();
        System.out.println("结尾");
    }
    public abstract void Write_mid();

}
