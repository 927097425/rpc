package com.ithima.Test1Date;

import java.util.Date;

public class Test1Date {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(System.currentTimeMillis());
        d.setTime(System.currentTimeMillis());
        System.out.println(d);
        Date d2 = new Date(System.currentTimeMillis());
        System.out.println(d2);


    }

}
