package Train.Final.Problem4;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> Moneys = new ArrayList<>();
        Random r= new Random();
        for (int i = 0;i<160;i++)Moneys.add(r.nextInt(1,31));
        for(int i = 0;i<40;i++) Moneys.add(r.nextInt(31,101));
        System.out.println(Moneys);
        Collections.shuffle(Moneys);
        List<FutureTask> employees = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            employees.add(new FutureTask<> (new Employee(Moneys)));
            new Thread(employees.get(i),"员工"+(i+1)).start();
        }

        for (FutureTask employee : employees){
            System.out.println(employee.get());
        }


    }
}
