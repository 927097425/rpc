package Train.Middian.Problem1;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Prison {
    private static final int PRISION_CAPACITY = 100;
    private List<Prisoner> P = new ArrayList<>();
    public Prison() {
        int r_nums = 0;
        Random r = new Random();
        int[] codes_cons;

        do {
            codes_cons = r.ints(500, 1, 201).distinct().limit(100).toArray();
            System.out.println(codes_cons.length);
        }
        while (codes_cons.length < 100);

        for (int i = 0; i < codes_cons.length; i++) {
            Prisoner cons = new Prisoner();
            cons.setCode_number(codes_cons[i]);
            cons.setName("cons"+(i+1));
            cons.setPos(i+1);
            P.add(cons);
        }
    }

    public List<Prisoner> getP() {
        return P;
    }

    public void setP(List<Prisoner> p) {
        P = p;
    }

    public void excution(){
        List<Prisoner> new_Prison = new ArrayList<>();
        for (int i = 0; i < P.size(); i++) {
            if(i%2==1)new_Prison.add(P.get(i));
        }
        P = new_Prison;
    }


    @Override
    public String toString(){
        return "Prison contains  "+ P.size() +" Prisoner";
    }

}
