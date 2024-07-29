package Guess_number;

import java.util.Random;

public class Producer extends Thread{
    private static int number;

    @Override
    public void run() {
        Random r = new Random();
        number = r.nextInt(1,100);
        this.notify();
        try {
            this.wait();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
