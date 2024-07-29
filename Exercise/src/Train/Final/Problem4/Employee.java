package Train.Final.Problem4;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

public class Employee implements Callable {
    private int account;

    List<Integer> Moneys;
    Employee(List<Integer> Moneys){

        this.Moneys = Moneys;
    }

    @Override
    public  Integer call() {
            while (true) {
                synchronized (Moneys) {
                if(!Moneys.isEmpty()) {
                    int money = Moneys.remove(0);
                    System.out.println(Thread.currentThread().getName() + "抢到了" + money);
                    account += money;
                }
                else break;
            }
        }
            return account;
    }

    public int getAccount() {
        return account;
    }


}
