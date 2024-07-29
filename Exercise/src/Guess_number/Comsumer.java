package Guess_number;

import java.util.Scanner;

public class Comsumer extends Thread{
    public static int number;

    @Override
    public void run() {
        System.out.println("请输入一个您猜测的数字:");
        Scanner sc  = new Scanner(System.in);
        int user = sc.nextInt();

    }
}
