package com.ithima.Scanner_test;

import java.util.Objects;
import java.util.Scanner;

//1,2,3,4,5分割字符串
public class Test {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter:");
        String s_in = sc.nextLine();
        String[] strs = new String[5];
        if(s_in!=null){
            strs = s_in.split(",");
        }


    }
}
